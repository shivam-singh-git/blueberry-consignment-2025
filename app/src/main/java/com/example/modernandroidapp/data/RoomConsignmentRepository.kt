package com.example.modernandroidapp.data

import com.example.modernandroidapp.data.dao.ConsignmentDao
import com.example.modernandroidapp.data.dao.ConsignmentItemDao
import com.example.modernandroidapp.data.entity.ConsignmentEntity
import com.example.modernandroidapp.data.entity.ConsignmentItemEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomConsignmentRepository @Inject constructor(
    private val consignmentDao: ConsignmentDao,
    private val consignmentItemDao: ConsignmentItemDao
) : ConsignmentRepository {

    override fun getOngoingConsignments(): Flow<List<Consignment>> {
        return combine(
            consignmentDao.getOngoing(),
            consignmentItemDao.getAllItems()
        ) { consignmentEntities, allItemEntities ->
            consignmentEntities.map { consignmentEntity ->
                val items = allItemEntities.filter { it.consignmentId == consignmentEntity.id }
                Consignment(
                    id = consignmentEntity.id,
                    customerName = consignmentEntity.customerName,
                    items = items.map { it.toConsignmentItem() }
                )
            }
        }
    }

    override fun getConsignmentById(id: String): Flow<Consignment?> {
        return combine(
            consignmentDao.getById(id),
            consignmentItemDao.getItems(id)
        ) { consignmentEntity, itemEntities ->
            consignmentEntity?.let { entity ->
                Consignment(
                    id = entity.id,
                    customerName = entity.customerName,
                    items = itemEntities.map { it.toConsignmentItem() }
                )
            }
        }
    }

    fun getHistoryConsignments(): Flow<List<Consignment>> {
        return combine(
            consignmentDao.getCompleted(),
            consignmentItemDao.getAllItems()
        ) { consignmentEntities, allItemEntities ->
            consignmentEntities.map { consignmentEntity ->
                val items = allItemEntities.filter { it.consignmentId == consignmentEntity.id }
                Consignment(
                    id = consignmentEntity.id,
                    customerName = consignmentEntity.customerName,
                    items = items.map { it.toConsignmentItem() }
                )
            }
        }
    }

    suspend fun addConsignment(customerName: String, items: List<ConsignmentItem>) {
        val consignmentId = UUID.randomUUID().toString()
        val consignmentEntity = ConsignmentEntity(
            id = consignmentId,
            customerName = customerName,
            completed = false
        )
        
        val itemEntities = items.map { item ->
            ConsignmentItemEntity(
                id = item.id.ifBlank { UUID.randomUUID().toString() },
                consignmentId = consignmentId,
                name = item.itemName,
                description = item.description,
                quantity = item.quantity,
                deliveredQuantity = item.deliveredQuantity,
                reminderFrequency = item.reminderFrequency.name
            )
        }
        
        consignmentDao.insert(consignmentEntity)
        consignmentItemDao.insertAll(itemEntities)
    }

    suspend fun updateDeliveredQuantity(consignmentId: String, itemIndex: Int, deliveredQuantity: Int) {
        // Get all items for this consignment
        val itemEntities = consignmentItemDao.getItems(consignmentId)
            .firstOrNull() ?: return
        if (itemIndex < 0 || itemIndex >= itemEntities.size) return
        val itemEntity = itemEntities[itemIndex]
        val newDeliveredQuantity = deliveredQuantity.coerceIn(0, itemEntity.quantity)
        consignmentItemDao.updateDeliveredQuantity(itemEntity.id, newDeliveredQuantity)
    }

    suspend fun moveToHistory(consignmentId: String) {
        consignmentDao.markAsCompleted(consignmentId, System.currentTimeMillis())
    }

    suspend fun initializeSampleData() {
        // Add sample ongoing consignments
        addConsignment(
            "John Smith",
            listOf(
                ConsignmentItem(
                    itemName = "Laptop",
                    description = "Dell XPS 13",
                    quantity = 1,
                    deliveredQuantity = 0
                ),
                ConsignmentItem(
                    itemName = "Mouse",
                    description = "Wireless Logitech",
                    quantity = 2,
                    deliveredQuantity = 2
                )
            )
        )
        
        addConsignment(
            "Sarah Johnson",
            listOf(
                ConsignmentItem(
                    itemName = "Monitor",
                    description = "27-inch 4K",
                    quantity = 1,
                    deliveredQuantity = 0
                ),
                ConsignmentItem(
                    itemName = "Keyboard",
                    description = "Mechanical RGB",
                    quantity = 1,
                    deliveredQuantity = 0
                )
            )
        )
        
        // Add sample completed consignments
        val completedConsignmentId = UUID.randomUUID().toString()
        val completedConsignmentEntity = ConsignmentEntity(
            id = completedConsignmentId,
            customerName = "Mike Wilson",
            completed = true,
            deliveryDate = System.currentTimeMillis()
        )
        
        val completedItemEntities = listOf(
            ConsignmentItemEntity(
                id = UUID.randomUUID().toString(),
                consignmentId = completedConsignmentId,
                name = "Desktop PC",
                description = "Gaming Desktop",
                quantity = 1,
                deliveredQuantity = 1
            ),
            ConsignmentItemEntity(
                id = UUID.randomUUID().toString(),
                consignmentId = completedConsignmentId,
                name = "Headphones",
                description = "Wireless Gaming Headset",
                quantity = 1,
                deliveredQuantity = 1
            )
        )
        
        consignmentDao.insert(completedConsignmentEntity)
        consignmentItemDao.insertAll(completedItemEntities)
    }

    // Extension functions for mapping between entities and domain models
    private fun ConsignmentItemEntity.toConsignmentItem(): ConsignmentItem {
        return ConsignmentItem(
            itemName = this.name,
            description = this.description,
            quantity = this.quantity,
            deliveredQuantity = this.deliveredQuantity,
            delivered = this.deliveredQuantity >= this.quantity,
            reminderFrequency = ReminderFrequency.valueOf(this.reminderFrequency)
        )
    }
} 
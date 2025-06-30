package com.example.modernandroidapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InMemoryConsignmentRepository @Inject constructor() : ConsignmentRepository {
    
    private val _consignments = MutableStateFlow<List<Consignment>>(emptyList())
    private val _historyConsignments = MutableStateFlow<List<Consignment>>(emptyList())
    
    init {
        // Sample data has been removed.
    }
    
    private fun addSampleData() {
        val sampleConsignments = listOf(
            Consignment(
                id = UUID.randomUUID().toString(),
                customerName = "John Smith",
                items = listOf(
                    ConsignmentItem(
                        itemName = "Laptop",
                        description = "Dell XPS 13",
                        quantity = 1,
                        delivered = false,
                        deliveredQuantity = 0
                    ),
                    ConsignmentItem(
                        itemName = "Mouse",
                        description = "Wireless Logitech",
                        quantity = 2,
                        delivered = true,
                        deliveredQuantity = 2
                    )
                )
            ),
            Consignment(
                id = UUID.randomUUID().toString(),
                customerName = "Sarah Johnson",
                items = listOf(
                    ConsignmentItem(
                        itemName = "Monitor",
                        description = "27-inch 4K",
                        quantity = 1,
                        delivered = false,
                        deliveredQuantity = 0
                    ),
                    ConsignmentItem(
                        itemName = "Keyboard",
                        description = "Mechanical RGB",
                        quantity = 1,
                        delivered = false,
                        deliveredQuantity = 0
                    )
                )
            )
        )
        
        _consignments.value = sampleConsignments
        
        // Add some sample completed consignments to history
        val sampleCompletedConsignments = listOf(
            Consignment(
                id = UUID.randomUUID().toString(),
                customerName = "Mike Wilson",
                items = listOf(
                    ConsignmentItem(
                        itemName = "Desktop PC",
                        description = "Gaming Desktop",
                        quantity = 1,
                        delivered = true,
                        deliveredQuantity = 1
                    ),
                    ConsignmentItem(
                        itemName = "Headphones",
                        description = "Wireless Gaming Headset",
                        quantity = 1,
                        delivered = true,
                        deliveredQuantity = 1
                    )
                )
            ),
            Consignment(
                id = UUID.randomUUID().toString(),
                customerName = "Emily Davis",
                items = listOf(
                    ConsignmentItem(
                        itemName = "Tablet",
                        description = "iPad Pro 12.9",
                        quantity = 1,
                        delivered = true,
                        deliveredQuantity = 1
                    ),
                    ConsignmentItem(
                        itemName = "Stylus",
                        description = "Apple Pencil",
                        quantity = 1,
                        delivered = true,
                        deliveredQuantity = 1
                    ),
                    ConsignmentItem(
                        itemName = "Case",
                        description = "Protective Cover",
                        quantity = 1,
                        delivered = true,
                        deliveredQuantity = 1
                    )
                )
            )
        )
        
        _historyConsignments.value = sampleCompletedConsignments
    }
    
    override fun getOngoingConsignments(): Flow<List<Consignment>> {
        return _consignments.map { consignments ->
            consignments.filter { consignment ->
                // A consignment is ongoing if at least one item is not delivered
                consignment.items.any { !it.delivered }
            }
        }
    }
    
    override fun getConsignmentById(id: String): Flow<Consignment?> {
        return _consignments.map { consignments ->
            consignments.find { it.id == id }
        }
    }

    override suspend fun addConsignment(consignment: Consignment) {
        _consignments.value = _consignments.value + consignment
    }

    override suspend fun updateConsignment(consignment: Consignment) {
        val allConsignments = (_consignments.value + _historyConsignments.value).toMutableList()
        val index = allConsignments.indexOfFirst { it.id == consignment.id }
        if (index != -1) {
            allConsignments[index] = consignment
            _consignments.value = allConsignments.filterNot { it.items.all { item -> item.delivered } }
            _historyConsignments.value = allConsignments.filter { it.items.all { item -> item.delivered } }
        }
    }

    fun getHistoryConsignments(): Flow<List<Consignment>> {
        return _historyConsignments
    }
    
    fun addConsignment(customerName: String, items: List<ConsignmentItem>) {
        val newConsignment = Consignment(
            id = UUID.randomUUID().toString(),
            customerName = customerName,
            items = items
        )
        
        val currentList = _consignments.value.toMutableList()
        currentList.add(newConsignment)
        _consignments.value = currentList
    }
    
    fun updateDeliveredQuantity(consignmentId: String, itemIndex: Int, deliveredQuantity: Int) {
        val currentList = _consignments.value.toMutableList()
        val consignmentIndex = currentList.indexOfFirst { it.id == consignmentId }
        if (consignmentIndex != -1 && itemIndex < currentList[consignmentIndex].items.size) {
            val consignment = currentList[consignmentIndex]
            val updatedItems = consignment.items.toMutableList()
            val item = updatedItems[itemIndex]
            val newDeliveredQuantity = deliveredQuantity.coerceIn(0, item.quantity)
            updatedItems[itemIndex] = item.copy(
                deliveredQuantity = newDeliveredQuantity,
                delivered = newDeliveredQuantity == item.quantity
            )
            currentList[consignmentIndex] = consignment.copy(items = updatedItems)
            _consignments.value = currentList
        }
    }

    fun moveToHistory(consignmentId: String) {
        val currentList = _consignments.value.toMutableList()
        val consignmentIndex = currentList.indexOfFirst { it.id == consignmentId }
        if (consignmentIndex != -1) {
            val consignment = currentList.removeAt(consignmentIndex)
            _consignments.value = currentList
            val historyList = _historyConsignments.value.toMutableList()
            historyList.add(consignment)
            _historyConsignments.value = historyList
        }
    }
    
    fun updateItemDeliveryStatus(consignmentId: String, itemIndex: Int, delivered: Boolean) {
        val currentList = _consignments.value.toMutableList()
        val consignmentIndex = currentList.indexOfFirst { it.id == consignmentId }
        
        if (consignmentIndex != -1 && itemIndex < currentList[consignmentIndex].items.size) {
            val consignment = currentList[consignmentIndex]
            val updatedItems = consignment.items.toMutableList()
            updatedItems[itemIndex] = updatedItems[itemIndex].copy(delivered = delivered)
            
            currentList[consignmentIndex] = consignment.copy(items = updatedItems)
            _consignments.value = currentList
        }
    }

    override suspend fun deleteConsignment(consignmentId: String) {
        _consignments.value = _consignments.value.filterNot { it.id == consignmentId }
        _historyConsignments.value = _historyConsignments.value.filterNot { it.id == consignmentId }
    }
} 
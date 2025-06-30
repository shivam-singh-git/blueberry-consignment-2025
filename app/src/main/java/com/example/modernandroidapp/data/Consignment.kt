package com.example.modernandroidapp.data

import java.util.UUID

enum class ReminderFrequency { DAILY, WEEKLY }

data class ConsignmentItem(
    val id: String = UUID.randomUUID().toString(),
    var itemName: String = "",
    var description: String = "",
    var quantity: Int = 1,
    var reminderFrequency: ReminderFrequency = ReminderFrequency.DAILY,
    var delivered: Boolean = false,
    var deliveredQuantity: Int = 0
)

data class Consignment(
    val id: String,
    val customerName: String,
    val items: List<ConsignmentItem>
)

object FakeConsignmentRepository {
    private val consignments = mutableListOf<Consignment>()
    fun addConsignment(consignment: Consignment) {
        consignments.add(consignment)
    }
    fun getConsignments(): List<Consignment> = consignments.toList()
} 
package com.example.modernandroidapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "consignment_items",
    foreignKeys = [
        ForeignKey(
            entity = ConsignmentEntity::class,
            parentColumns = ["id"],
            childColumns = ["consignmentId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("consignmentId")]
)
data class ConsignmentItemEntity(
    @PrimaryKey
    val id: String,
    val consignmentId: String,
    val name: String,
    val description: String,
    val quantity: Int,
    val deliveredQuantity: Int = 0,
    val reminderFrequency: String = "DAILY"
) 
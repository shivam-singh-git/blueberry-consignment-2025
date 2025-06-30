package com.example.modernandroidapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consignments")
data class ConsignmentEntity(
    @PrimaryKey
    val id: String,
    val customerName: String,
    val completed: Boolean = false,
    val deliveryDate: Long? = null
) 
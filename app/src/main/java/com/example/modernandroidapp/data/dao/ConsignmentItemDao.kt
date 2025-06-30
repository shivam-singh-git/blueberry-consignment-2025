package com.example.modernandroidapp.data.dao

import androidx.room.*
import com.example.modernandroidapp.data.entity.ConsignmentItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsignmentItemDao {
    @Query("SELECT * FROM consignment_items WHERE consignmentId = :consignmentId")
    fun getItems(consignmentId: String): Flow<List<ConsignmentItemEntity>>
    
    @Query("SELECT * FROM consignment_items")
    fun getAllItems(): Flow<List<ConsignmentItemEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ConsignmentItemEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ConsignmentItemEntity>)
    
    @Update
    suspend fun update(item: ConsignmentItemEntity)
    
    @Query("UPDATE consignment_items SET deliveredQuantity = :deliveredQuantity WHERE id = :itemId")
    suspend fun updateDeliveredQuantity(itemId: String, deliveredQuantity: Int)
} 
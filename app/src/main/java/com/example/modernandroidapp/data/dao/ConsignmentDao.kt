package com.example.modernandroidapp.data.dao

import androidx.room.*
import com.example.modernandroidapp.data.entity.ConsignmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsignmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(consignment: ConsignmentEntity)

    @Update
    suspend fun update(consignment: ConsignmentEntity)

    @Query("SELECT * FROM consignments")
    fun getAll(): Flow<List<ConsignmentEntity>>

    @Query("SELECT * FROM consignments WHERE completed = 0")
    fun getOngoing(): Flow<List<ConsignmentEntity>>

    @Query("SELECT * FROM consignments WHERE completed = 1 ORDER BY deliveryDate DESC")
    fun getCompleted(): Flow<List<ConsignmentEntity>>

    @Query("SELECT * FROM consignments WHERE id = :consignmentId")
    fun getById(consignmentId: String): Flow<ConsignmentEntity?>

    @Query("UPDATE consignments SET completed = 1, deliveryDate = :deliveryDate WHERE id = :consignmentId")
    suspend fun markAsCompleted(consignmentId: String, deliveryDate: Long)

    @Query("DELETE FROM consignments WHERE id = :consignmentId")
    suspend fun deleteConsignmentById(consignmentId: String)
} 
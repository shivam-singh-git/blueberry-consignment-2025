package com.example.modernandroidapp.data

import kotlinx.coroutines.flow.Flow

interface ConsignmentRepository {
    fun getOngoingConsignments(): Flow<List<Consignment>>
    fun getConsignmentById(id: String): Flow<Consignment?>
    suspend fun addConsignment(consignment: Consignment)
    suspend fun updateConsignment(consignment: Consignment)
    suspend fun deleteConsignment(consignmentId: String)
} 
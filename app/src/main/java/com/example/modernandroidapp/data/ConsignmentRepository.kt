package com.example.modernandroidapp.data

import kotlinx.coroutines.flow.Flow

interface ConsignmentRepository {
    fun getOngoingConsignments(): Flow<List<Consignment>>
    fun getConsignmentById(id: String): Flow<Consignment?>
} 
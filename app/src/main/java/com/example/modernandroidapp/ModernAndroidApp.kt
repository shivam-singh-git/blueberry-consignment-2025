package com.example.modernandroidapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.example.modernandroidapp.data.RoomConsignmentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class ModernAndroidApp : Application() {
    
    @Inject
    lateinit var repository: RoomConsignmentRepository
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize sample data
        CoroutineScope(Dispatchers.IO).launch {
            repository.initializeSampleData()
        }
    }
} 
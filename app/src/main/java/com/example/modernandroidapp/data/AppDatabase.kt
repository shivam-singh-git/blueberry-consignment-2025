package com.example.modernandroidapp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.modernandroidapp.data.dao.ConsignmentDao
import com.example.modernandroidapp.data.dao.ConsignmentItemDao
import com.example.modernandroidapp.data.entity.ConsignmentEntity
import com.example.modernandroidapp.data.entity.ConsignmentItemEntity

@Database(
    entities = [ConsignmentEntity::class, ConsignmentItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun consignmentDao(): ConsignmentDao
    abstract fun consignmentItemDao(): ConsignmentItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "consignment_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
} 
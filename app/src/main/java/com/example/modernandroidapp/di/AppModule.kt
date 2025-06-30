package com.example.modernandroidapp.di

import android.content.Context
import com.example.modernandroidapp.data.UserSessionManager
import com.example.modernandroidapp.data.ConsignmentRepository
import com.example.modernandroidapp.data.RoomConsignmentRepository
import com.example.modernandroidapp.data.AppDatabase
import com.example.modernandroidapp.data.dao.ConsignmentDao
import com.example.modernandroidapp.data.dao.ConsignmentItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserSessionManager(@ApplicationContext context: Context): UserSessionManager =
        UserSessionManager(context)
    
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context)
    
    @Provides
    @Singleton
    fun provideConsignmentDao(database: AppDatabase): ConsignmentDao =
        database.consignmentDao()
    
    @Provides
    @Singleton
    fun provideConsignmentItemDao(database: AppDatabase): ConsignmentItemDao =
        database.consignmentItemDao()
    
    @Provides
    @Singleton
    fun provideConsignmentRepository(repository: RoomConsignmentRepository): ConsignmentRepository =
        repository
} 
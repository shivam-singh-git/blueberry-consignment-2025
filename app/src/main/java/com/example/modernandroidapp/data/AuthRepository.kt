package com.example.modernandroidapp.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor() {
    
    // Mock user database - in a real app, this would come from a remote API or local database
    private val users = listOf(
        User("admin", "admin123", UserRole.ADMIN),
        User("staff", "staff123", UserRole.STAFF)
    )

    suspend fun login(username: String, password: String): User? {
        // Simulate network delay
        kotlinx.coroutines.delay(1000)
        
        return users.find { user ->
            user.username == username && user.password == password
        }
    }

    suspend fun validateCredentials(username: String, password: String): Boolean {
        return users.any { user ->
            user.username == username && user.password == password
        }
    }
} 
package com.example.modernandroidapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernandroidapp.data.UserRole
import com.example.modernandroidapp.data.UserSessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userSessionManager: UserSessionManager
) : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private val _currentUsername = MutableStateFlow<String?>(null)
    val currentUsername: StateFlow<String?> = _currentUsername.asStateFlow()

    private val _currentUserRole = MutableStateFlow<UserRole?>(null)
    val currentUserRole: StateFlow<UserRole?> = _currentUserRole.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                userSessionManager.isLoggedIn,
                userSessionManager.currentUsername,
                userSessionManager.currentUserRole
            ) { isLoggedIn, username, role ->
                Triple(isLoggedIn, username, role)
            }.collect { (isLoggedIn, username, role) ->
                _isLoggedIn.value = isLoggedIn
                _currentUsername.value = username
                _currentUserRole.value = role
            }
        }
    }

    fun checkSessionOnLaunch() {
        viewModelScope.launch {
            val role = userSessionManager.currentUserRole.first()
            _currentUserRole.value = role
            _isLoggedIn.value = role != null
        }
    }

    fun logout() {
        viewModelScope.launch {
            userSessionManager.clearSession()
        }
    }
} 
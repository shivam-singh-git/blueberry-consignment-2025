package com.example.modernandroidapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernandroidapp.data.Consignment
import com.example.modernandroidapp.data.ConsignmentRepository
import com.example.modernandroidapp.data.RoomConsignmentRepository
import com.example.modernandroidapp.data.UserRole
import com.example.modernandroidapp.data.UserSessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsignmentDetailViewModel @Inject constructor(
    private val repository: ConsignmentRepository,
    private val roomRepository: RoomConsignmentRepository,
    private val userSessionManager: UserSessionManager
) : ViewModel() {
    
    private val _consignment = MutableStateFlow<Consignment?>(null)
    val consignment: StateFlow<Consignment?> = _consignment
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    
    private val _hasUnsavedChanges = MutableStateFlow(false)
    val hasUnsavedChanges: StateFlow<Boolean> = _hasUnsavedChanges
    
    private val _isSaving = MutableStateFlow(false)
    val isSaving: StateFlow<Boolean> = _isSaving
    
    private val _saveSuccess = MutableStateFlow(false)
    val saveSuccess: StateFlow<Boolean> = _saveSuccess
    
    private val _currentUserRole = MutableStateFlow<UserRole?>(null)
    val currentUserRole: StateFlow<UserRole?> = _currentUserRole
    
    init {
        viewModelScope.launch {
            userSessionManager.currentUserRole.collect { role ->
                _currentUserRole.value = role
            }
        }
    }
    
    fun loadConsignment(consignmentId: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                // Get only the first value from the flow
                val consignment = repository.getConsignmentById(consignmentId).first()
                _consignment.value = consignment
                _hasUnsavedChanges.value = false
                _saveSuccess.value = false
            } catch (e: Exception) {
                // Handle error if needed
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun updateDeliveredQuantity(itemIndex: Int, deliveredQuantity: Int) {
        val currentConsignment = _consignment.value ?: return
        
        // Update the local state immediately (temporary changes)
        val updatedItems = currentConsignment.items.toMutableList()
        val item = updatedItems[itemIndex]
        val newDeliveredQuantity = deliveredQuantity.coerceIn(0, item.quantity)
        updatedItems[itemIndex] = item.copy(
            deliveredQuantity = newDeliveredQuantity,
            delivered = newDeliveredQuantity == item.quantity
        )
        
        val updatedConsignment = currentConsignment.copy(items = updatedItems)
        _consignment.value = updatedConsignment
        
        // Mark that there are unsaved changes
        _hasUnsavedChanges.value = true
    }
    
    fun updateCustomerName(newCustomerName: String) {
        val currentConsignment = _consignment.value ?: return
        val updatedConsignment = currentConsignment.copy(customerName = newCustomerName)
        _consignment.value = updatedConsignment
        _hasUnsavedChanges.value = true
    }
    
    fun updateItemName(itemIndex: Int, newItemName: String) {
        val currentConsignment = _consignment.value ?: return
        val updatedItems = currentConsignment.items.toMutableList()
        val item = updatedItems[itemIndex]
        updatedItems[itemIndex] = item.copy(itemName = newItemName)
        
        val updatedConsignment = currentConsignment.copy(items = updatedItems)
        _consignment.value = updatedConsignment
        _hasUnsavedChanges.value = true
    }
    
    fun updateItemDescription(itemIndex: Int, newDescription: String) {
        val currentConsignment = _consignment.value ?: return
        val updatedItems = currentConsignment.items.toMutableList()
        val item = updatedItems[itemIndex]
        updatedItems[itemIndex] = item.copy(description = newDescription)
        
        val updatedConsignment = currentConsignment.copy(items = updatedItems)
        _consignment.value = updatedConsignment
        _hasUnsavedChanges.value = true
    }
    
    fun updateItemQuantity(itemIndex: Int, newQuantity: Int) {
        val currentConsignment = _consignment.value ?: return
        val updatedItems = currentConsignment.items.toMutableList()
        val item = updatedItems[itemIndex]
        val validQuantity = newQuantity.coerceAtLeast(1)
        val newDeliveredQuantity = item.deliveredQuantity.coerceAtMost(validQuantity)
        
        updatedItems[itemIndex] = item.copy(
            quantity = validQuantity,
            deliveredQuantity = newDeliveredQuantity,
            delivered = newDeliveredQuantity == validQuantity
        )
        
        val updatedConsignment = currentConsignment.copy(items = updatedItems)
        _consignment.value = updatedConsignment
        _hasUnsavedChanges.value = true
    }
    
    fun saveConsignment() {
        saveChanges()
    }
    
    fun saveChanges() {
        val currentConsignment = _consignment.value ?: return
        
        _isSaving.value = true
        
        viewModelScope.launch {
            try {
                // Update all delivered quantities in the database
                currentConsignment.items.forEachIndexed { index, item ->
                    roomRepository.updateDeliveredQuantity(currentConsignment.id, index, item.deliveredQuantity)
                }
                
                // Check if all items are delivered and move to history if so
                if (currentConsignment.items.all { it.delivered }) {
                    roomRepository.moveToHistory(currentConsignment.id)
                }
                
                _hasUnsavedChanges.value = false
                _saveSuccess.value = true
            } catch (e: Exception) {
                // Handle error if needed
            } finally {
                _isSaving.value = false
            }
        }
    }
    
    fun resetSaveSuccess() {
        _saveSuccess.value = false
    }
    
    fun hasChanges(): Boolean {
        return _hasUnsavedChanges.value
    }
    
    fun isAllItemsDelivered(): Boolean {
        return _consignment.value?.items?.all { it.delivered } ?: false
    }
    
    fun canEdit(): Boolean {
        return _currentUserRole.value == UserRole.ADMIN
    }
} 
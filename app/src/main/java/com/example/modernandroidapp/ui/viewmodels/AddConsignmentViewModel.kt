package com.example.modernandroidapp.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernandroidapp.data.ConsignmentItem
import com.example.modernandroidapp.data.RoomConsignmentRepository
import com.example.modernandroidapp.data.ReminderFrequency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddConsignmentViewModel @Inject constructor(
    private val repository: RoomConsignmentRepository
) : ViewModel() {
    var customerName by mutableStateOf("")
        private set
    var items by mutableStateOf(listOf(ConsignmentItem()))
        private set
    var submitSuccess by mutableStateOf(false)
        private set
    var validationError by mutableStateOf<String?>(null)
        private set

    fun onCustomerNameChange(newName: String) {
        customerName = newName
    }

    fun onItemChange(index: Int, item: ConsignmentItem) {
        items = items.toMutableList().also { it[index] = item }
    }

    fun addItem() {
        items = items + ConsignmentItem()
    }

    fun removeItem(index: Int) {
        if (items.size > 1) {
            items = items.toMutableList().also { it.removeAt(index) }
        }
    }

    private fun validate(): Boolean {
        if (customerName.isBlank()) {
            validationError = "Customer name is required."
            return false
        }
        items.forEachIndexed { idx, item ->
            if (item.itemName.isBlank()) {
                validationError = "Item ${idx + 1}: Name is required."
                return false
            }
            if (item.quantity <= 0) {
                validationError = "Item ${idx + 1}: Quantity must be greater than 0."
                return false
            }
        }
        validationError = null
        return true
    }

    fun onSubmit() {
        if (!validate()) return
        val itemsToAdd = items.map {
            it.copy(delivered = false, deliveredQuantity = 0)
        }
        viewModelScope.launch {
            repository.addConsignment(customerName, itemsToAdd)
            submitSuccess = true
            // Reset form
            customerName = ""
            items = listOf(ConsignmentItem())
        }
    }
} 
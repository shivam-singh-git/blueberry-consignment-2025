package com.example.modernandroidapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modernandroidapp.data.Consignment
import com.example.modernandroidapp.data.RoomConsignmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: RoomConsignmentRepository
) : ViewModel() {
    
    val completedConsignments: StateFlow<List<Consignment>> =
        repository.getHistoryConsignments()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
} 
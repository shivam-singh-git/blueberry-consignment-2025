package com.example.modernandroidapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailViewModel
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.foundation.clickable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsignmentDetailScreen(
    consignmentId: String,
    onNavigateBack: () -> Unit,
    viewModel: ConsignmentDetailViewModel = hiltViewModel()
) {
    val consignment by viewModel.consignment.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isSaving by viewModel.isSaving.collectAsState()
    val hasUnsavedChanges by viewModel.hasUnsavedChanges.collectAsState()
    val saveSuccess by viewModel.saveSuccess.collectAsState()
    val currentUserRole by viewModel.currentUserRole.collectAsState()

    LaunchedEffect(consignmentId) {
        viewModel.loadConsignment(consignmentId)
    }

    LaunchedEffect(saveSuccess) {
        if (saveSuccess) {
            onNavigateBack()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Consignment Details",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                actions = {
                    AnimatedVisibility(
                        visible = hasUnsavedChanges,
                        enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                            initialOffsetY = { -it / 2 },
                            animationSpec = spring(dampingRatio = 0.8f, stiffness = 300f)
                        ),
                        exit = fadeOut(animationSpec = tween(200))
                    ) {
                        Text(
                            "Unsaved",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                    IconButton(
                        onClick = { viewModel.saveConsignment() },
                        enabled = hasUnsavedChanges && !isSaving
                    ) {
                        if (isSaving) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = MaterialTheme.colorScheme.primary,
                                strokeWidth = 2.dp
                            )
                        } else {
                            val saveIconColor by animateColorAsState(
                                targetValue = if (hasUnsavedChanges) 
                                    MaterialTheme.colorScheme.primary 
                                else 
                                    MaterialTheme.colorScheme.onSurfaceVariant,
                                animationSpec = tween(300),
                                label = "saveIconColor"
                            )
                            Icon(
                                Icons.Filled.Save,
                                contentDescription = "Save",
                                tint = saveIconColor
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { padding ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            consignment?.let { consignment ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(horizontal = 16.dp),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        CustomerInfoRow(
                            consignment = consignment,
                            currentUserRole = currentUserRole,
                            viewModel = viewModel
                        )
                    }
                    item {
                        ItemsHeader()
                    }
                    itemsIndexed(
                        items = consignment.items,
                        key = { index, item -> "${item.id}_$index" }
                    ) { index, item ->
                        ModernItemDetailCard(
                            item = item,
                            index = index,
                            currentUserRole = currentUserRole,
                            viewModel = viewModel,
                            onQuantityChange = { newQuantity ->
                                viewModel.updateDeliveredQuantity(index, newQuantity)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomerInfoRow(
    consignment: com.example.modernandroidapp.data.Consignment,
    currentUserRole: com.example.modernandroidapp.data.UserRole?,
    viewModel: ConsignmentDetailViewModel
) {
    var isEditing by remember { mutableStateOf(false) }
    var editedCustomerName by remember { mutableStateOf(consignment.customerName) }
    
    LaunchedEffect(consignment.customerName) {
        editedCustomerName = consignment.customerName
    }
    
    val canEdit = currentUserRole == com.example.modernandroidapp.data.UserRole.ADMIN
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.medium)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Customer",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        
        if (isEditing && canEdit) {
            OutlinedTextField(
                value = editedCustomerName,
                onValueChange = { editedCustomerName = it },
                modifier = Modifier.weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                ),
                shape = MaterialTheme.shapes.small,
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = {
                    viewModel.updateCustomerName(editedCustomerName)
                    isEditing = false
                }
            ) {
                Icon(
                    Icons.Filled.Save,
                    contentDescription = "Save",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
            }
        } else {
            Text(
                text = consignment.customerName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            if (canEdit) {
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = { isEditing = true }
                ) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            imageVector = Icons.Filled.Inventory,
            contentDescription = "Items",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "${consignment.items.size} items",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ItemsHeader() {
    Text(
        "Items",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun ModernItemDetailCard(
    item: com.example.modernandroidapp.data.ConsignmentItem,
    index: Int,
    currentUserRole: com.example.modernandroidapp.data.UserRole?,
    viewModel: ConsignmentDetailViewModel,
    onQuantityChange: (Int) -> Unit
) {
    val isCompleted by remember(item.deliveredQuantity, item.quantity) {
        derivedStateOf { item.deliveredQuantity >= item.quantity }
    }
    
    val canEdit = currentUserRole == com.example.modernandroidapp.data.UserRole.ADMIN
    
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp
    ) {
        Column(Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.itemName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (item.description.isNotBlank()) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                AssistChip(
                    onClick = {},
                    label = {
                        Text(
                            if (isCompleted) "Complete" else "Pending",
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = if (isCompleted) Icons.Filled.CheckCircle else Icons.Filled.Pending,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (isCompleted) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant,
                        labelColor = if (isCompleted) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    border = null
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivered:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(8.dp))
                ModernStepper(
                    value = item.deliveredQuantity,
                    range = 0..item.quantity,
                    onValueChange = onQuantityChange,
                    enabled = canEdit || currentUserRole == com.example.modernandroidapp.data.UserRole.STAFF
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "/${item.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun ModernStepper(
    value: Int,
    range: IntRange,
    onValueChange: (Int) -> Unit,
    enabled: Boolean
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = { if (value > range.first) onValueChange(value - 1) },
            enabled = enabled && value > range.first
        ) {
            Icon(
                Icons.Filled.Remove,
                contentDescription = "Decrease",
                modifier = Modifier.size(18.dp)
            )
        }
        OutlinedTextField(
            value = value.toString(),
            onValueChange = {
                val newValue = it.toIntOrNull()
                if (newValue != null && newValue in range) onValueChange(newValue)
            },
            modifier = Modifier.width(56.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
            singleLine = true,
            enabled = enabled,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                focusedLabelColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.small
        )
        IconButton(
            onClick = { if (value < range.last) onValueChange(value + 1) },
            enabled = enabled && value < range.last
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Increase",
                modifier = Modifier.size(18.dp)
            )
        }
    }
} 
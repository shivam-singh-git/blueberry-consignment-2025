package com.example.modernandroidapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.material.icons.outlined.Edit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsignmentDetailScreen(
    consignmentId: String,
    onNavigateBack: () -> Unit,
    onLogout: () -> Unit,
    viewModel: ConsignmentDetailViewModel = hiltViewModel()
) {
    val consignment by viewModel.consignment.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isSaving by viewModel.isSaving.collectAsState()
    val hasUnsavedChanges by viewModel.hasUnsavedChanges.collectAsState()
    val saveSuccess by viewModel.saveSuccess.collectAsState()
    val currentUserRole by viewModel.currentUserRole.collectAsState()

    LaunchedEffect(consignmentId) { viewModel.loadConsignment(consignmentId) }
    LaunchedEffect(saveSuccess) { if (saveSuccess) onNavigateBack() }

    Scaffold(
        containerColor = Color(0xFFF9FAFB),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Consignment Details",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { viewModel.saveConsignment() },
                        enabled = hasUnsavedChanges && !isSaving
                    ) {
                        if (isSaving) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                color = MaterialTheme.colorScheme.primary,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Icon(
                                Icons.Filled.Save,
                                contentDescription = "Save",
                                tint = if (hasUnsavedChanges) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    IconButton(onClick = onLogout) {
                        Icon(
                            Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Logout",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
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
                CircularProgressIndicator(color = Color(0xFF4F46E5))
            }
        } else {
            consignment?.let { consignment ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF9FAFB))
                        .padding(top = padding.calculateTopPadding())
                ) {
                    ConsignmentTitleCard(
                        name = consignment.customerName,
                        itemCount = consignment.items.size,
                        isAdmin = currentUserRole == com.example.modernandroidapp.data.UserRole.ADMIN,
                        onNameChange = { viewModel.updateCustomerName(it) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Text(
                                "Items",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                            )
                        }
                        itemsIndexed(
                            items = consignment.items,
                            key = { index, item -> "${item.id}_$index" }
                        ) { index, item ->
                            ConsignmentItemCard(
                                item = item,
                                canEdit = currentUserRole == com.example.modernandroidapp.data.UserRole.ADMIN || currentUserRole == com.example.modernandroidapp.data.UserRole.STAFF,
                                onQuantityChange = { newQuantity ->
                                    viewModel.updateDeliveredQuantity(index, newQuantity)
                                },
                                onItemEdit = { name, description, quantity ->
                                    viewModel.updateItem(index, name, description, quantity)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ConsignmentTitleCard(
    name: String,
    itemCount: Int,
    isAdmin: Boolean,
    onNameChange: (String) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var editedName by remember { mutableStateOf(name) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                tint = Color(0xFF4F46E5),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                if (isEditing && isAdmin) {
                    OutlinedTextField(
                        value = editedName,
                        onValueChange = { editedName = it },
                        textStyle = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF4F46E5),
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        ),
                        modifier = Modifier.fillMaxWidth(0.85f)
                    )
                } else {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Text(
                    text = "$itemCount item${if (itemCount == 1) "" else "s"}",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                    color = Color(0xFF94A3B8)
                )
            }
            if (isAdmin) {
                Spacer(modifier = Modifier.width(8.dp))
                if (isEditing) {
                    IconButton(
                        onClick = {
                            onNameChange(editedName)
                            isEditing = false
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = "Save Name",
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                } else {
                    IconButton(
                        onClick = { isEditing = true }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Edit Name",
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ConsignmentItemCard(
    item: com.example.modernandroidapp.data.ConsignmentItem,
    canEdit: Boolean,
    onQuantityChange: (Int) -> Unit,
    onItemEdit: (String, String, Int) -> Unit = { _, _, _ -> }
) {
    val isCompleted = item.deliveredQuantity >= item.quantity
    var isEditing by remember { mutableStateOf(false) }
    var editedName by remember { mutableStateOf(item.itemName) }
    var editedDescription by remember { mutableStateOf(item.description) }
    var editedQuantity by remember { mutableStateOf(item.quantity) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    if (isEditing && canEdit) {
                        OutlinedTextField(
                            value = editedName,
                            onValueChange = { editedName = it },
                            textStyle = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            singleLine = true,
                            label = { Text("Item Name", fontSize = 14.sp, color = Color.Gray) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        OutlinedTextField(
                            value = editedDescription,
                            onValueChange = { editedDescription = it },
                            textStyle = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                            singleLine = false,
                            label = { Text("Description (optional)", fontSize = 12.sp, color = Color.Gray) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Quantity:", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp), color = MaterialTheme.colorScheme.onSurface)
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(onClick = { if (editedQuantity > 1) editedQuantity-- }, enabled = editedQuantity > 1) {
                                Icon(Icons.Filled.Remove, contentDescription = "Decrease", tint = Color(0xFF4F46E5), modifier = Modifier.size(18.dp))
                            }
                            OutlinedTextField(
                                value = editedQuantity.toString(),
                                onValueChange = { it.toIntOrNull()?.let { v -> if (v > 0) editedQuantity = v } },
                                modifier = Modifier.width(48.dp).height(36.dp),
                                textStyle = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
                                singleLine = true
                            )
                            IconButton(onClick = { editedQuantity++ }) {
                                Icon(Icons.Filled.Add, contentDescription = "Increase", tint = Color(0xFF4F46E5), modifier = Modifier.size(18.dp))
                            }
                        }
                    } else {
                        Text(
                            text = item.itemName,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        if (item.description.isNotBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = item.description,
                                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                    }
                }
                if (canEdit) {
                    if (isEditing) {
                        IconButton(onClick = {
                            onItemEdit(editedName, editedDescription, editedQuantity)
                            isEditing = false
                        }) {
                            Icon(Icons.Filled.CheckCircle, contentDescription = "Save Item", tint = Color(0xFF4F46E5), modifier = Modifier.size(20.dp))
                        }
                    } else {
                        IconButton(onClick = { isEditing = true }) {
                            Icon(Icons.Outlined.Edit, contentDescription = "Edit Item", tint = Color.Gray, modifier = Modifier.size(18.dp))
                        }
                    }
                }
            }
            if (!isEditing) {
                StatusAssistChip(isCompleted)
            }
            if (!isEditing) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Delivered:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = { if (item.deliveredQuantity > 0) onQuantityChange(item.deliveredQuantity - 1) },
                        enabled = canEdit && item.deliveredQuantity > 0,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            Icons.Filled.Remove,
                            contentDescription = "Decrease",
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    QuantityBox(
                        value = item.deliveredQuantity,
                        total = item.quantity
                    )
                    IconButton(
                        onClick = { if (item.deliveredQuantity < item.quantity) onQuantityChange(item.deliveredQuantity + 1) },
                        enabled = canEdit && item.deliveredQuantity < item.quantity,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Increase",
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuantityBox(value: Int, total: Int) {
    Box(
        modifier = Modifier
            .height(36.dp)
            .padding(horizontal = 2.dp)
            .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium, fontSize = 14.sp),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = " / $total",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                color = Color(0xFF94A3B8),
                modifier = Modifier.padding(start = 2.dp)
            )
        }
    }
}

@Composable
fun StatusAssistChip(isCompleted: Boolean) {
    AssistChip(
        onClick = {},
        label = {
            Text(
                if (isCompleted) "Complete" else "Pending",
                style = MaterialTheme.typography.labelMedium.copy(fontSize = 12.sp)
            )
        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (isCompleted) Color(0xFFE0E7FF) else Color(0xFFF1F5F9),
            labelColor = if (isCompleted) Color(0xFF4F46E5) else Color(0xFF64748B)
        ),
        border = null,
        modifier = Modifier.height(28.dp)
    )
} 
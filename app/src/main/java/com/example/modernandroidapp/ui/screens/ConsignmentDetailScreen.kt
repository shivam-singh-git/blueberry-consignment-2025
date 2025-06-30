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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Modern animated dots loading indicator
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(3) { index ->
                            val infiniteTransition = rememberInfiniteTransition()
                            val scale by infiniteTransition.animateFloat(
                                initialValue = 0.3f,
                                targetValue = 1f,
                                animationSpec = infiniteRepeatable(
                                    animation = tween(600, delayMillis = index * 200),
                                    repeatMode = RepeatMode.Reverse
                                )
                            )
                            
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .scale(scale)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                    Text(
                        text = "Loading consignment...",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            consignment?.let { consignment ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentPadding = PaddingValues(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically(
                                initialOffsetY = { -it },
                                animationSpec = spring(dampingRatio = 0.8f, stiffness = 300f)
                            ) + fadeIn(animationSpec = tween(600))
                        ) {
                            CustomerInfoCard(
                                consignment = consignment,
                                currentUserRole = currentUserRole,
                                viewModel = viewModel
                            )
                        }
                    }
                    
                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(animationSpec = tween(800)) + slideInVertically(
                                initialOffsetY = { it / 2 },
                                animationSpec = spring(dampingRatio = 0.7f, stiffness = 200f)
                            )
                        ) {
                            ItemsHeader()
                        }
                    }
                    
                    itemsIndexed(
                        items = consignment.items,
                        key = { index, item -> "${item.id}_$index" }
                    ) { index, item ->
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(animationSpec = tween(600)) + slideInVertically(
                                initialOffsetY = { it / 2 },
                                animationSpec = spring(
                                    dampingRatio = 0.8f,
                                    stiffness = 250f,
                                    visibilityThreshold = null
                                )
                            )
                        ) {
                            ItemStepperCard(
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
}

@Composable
fun CustomerInfoCard(
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
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(Modifier.padding(24.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Customer",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
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
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                } else {
                    Text(
                        text = consignment.customerName,
                        style = MaterialTheme.typography.headlineSmall,
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
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Inventory,
                    contentDescription = "Items",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${consignment.items.size} items",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun ItemsHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Inventory,
            contentDescription = "Items",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            "Items",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ItemStepperCard(
    item: com.example.modernandroidapp.data.ConsignmentItem,
    index: Int,
    currentUserRole: com.example.modernandroidapp.data.UserRole?,
    viewModel: ConsignmentDetailViewModel,
    onQuantityChange: (Int) -> Unit
) {
    // Derived state to avoid recomposition when only completion status changes
    val isCompleted by remember(item.deliveredQuantity, item.quantity) {
        derivedStateOf { item.deliveredQuantity >= item.quantity }
    }
    
    // Animate completion status
    val completionColor by animateColorAsState(
        targetValue = if (isCompleted) 
            MaterialTheme.colorScheme.primaryContainer 
        else 
            MaterialTheme.colorScheme.surfaceVariant,
        animationSpec = tween(300),
        label = "completionColor"
    )
    
    val completionTextColor by animateColorAsState(
        targetValue = if (isCompleted) 
            MaterialTheme.colorScheme.onPrimaryContainer 
        else 
            MaterialTheme.colorScheme.onSurfaceVariant,
        animationSpec = tween(300),
        label = "completionTextColor"
    )
    
    // Animate quantity changes
    val animatedQuantity by animateFloatAsState(
        targetValue = item.deliveredQuantity.toFloat(),
        animationSpec = spring(
            dampingRatio = 0.8f,
            stiffness = 300f
        ),
        label = "quantity"
    )
    
    val canEdit = currentUserRole == com.example.modernandroidapp.data.UserRole.ADMIN
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    if (canEdit) {
                        var isEditingName by remember { mutableStateOf(false) }
                        var editedItemName by remember { mutableStateOf(item.itemName) }
                        
                        LaunchedEffect(item.itemName) {
                            editedItemName = item.itemName
                        }
                        
                        if (isEditingName) {
                            OutlinedTextField(
                                value = editedItemName,
                                onValueChange = { editedItemName = it },
                                label = { Text("Item Name") },
                                modifier = Modifier.fillMaxWidth(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                    focusedLabelColor = MaterialTheme.colorScheme.primary
                                ),
                                shape = MaterialTheme.shapes.small,
                                singleLine = true
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Row {
                                IconButton(
                                    onClick = {
                                        viewModel.updateItemName(index, editedItemName)
                                        isEditingName = false
                                    }
                                ) {
                                    Icon(
                                        Icons.Filled.Save,
                                        contentDescription = "Save",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                IconButton(
                                    onClick = { isEditingName = false }
                                ) {
                                    Icon(
                                        Icons.Filled.Close,
                                        contentDescription = "Cancel",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        } else {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = item.itemName,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(
                                    onClick = { isEditingName = true }
                                ) {
                                    Icon(
                                        Icons.Filled.Edit,
                                        contentDescription = "Edit Name",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(4.dp))
                        
                        var isEditingDescription by remember { mutableStateOf(false) }
                        var editedDescription by remember { mutableStateOf(item.description) }
                        
                        LaunchedEffect(item.description) {
                            editedDescription = item.description
                        }
                        
                        if (isEditingDescription) {
                            OutlinedTextField(
                                value = editedDescription,
                                onValueChange = { editedDescription = it },
                                label = { Text("Description (Optional)") },
                                modifier = Modifier.fillMaxWidth(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                    focusedLabelColor = MaterialTheme.colorScheme.primary
                                ),
                                shape = MaterialTheme.shapes.small
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Row {
                                IconButton(
                                    onClick = {
                                        viewModel.updateItemDescription(index, editedDescription)
                                        isEditingDescription = false
                                    }
                                ) {
                                    Icon(
                                        Icons.Filled.Save,
                                        contentDescription = "Save",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                IconButton(
                                    onClick = { isEditingDescription = false }
                                ) {
                                    Icon(
                                        Icons.Filled.Close,
                                        contentDescription = "Cancel",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        } else {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = item.description.ifEmpty { "No description" },
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(
                                    onClick = { isEditingDescription = true }
                                ) {
                                    Icon(
                                        Icons.Filled.Edit,
                                        contentDescription = "Edit Description",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        var isEditingQuantity by remember { mutableStateOf(false) }
                        var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
                        
                        LaunchedEffect(item.quantity) {
                            editedQuantity = item.quantity.toString()
                        }
                        
                        if (isEditingQuantity) {
                            OutlinedTextField(
                                value = editedQuantity,
                                onValueChange = { editedQuantity = it },
                                label = { Text("Total Quantity") },
                                modifier = Modifier.width(120.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                    focusedLabelColor = MaterialTheme.colorScheme.primary
                                ),
                                shape = MaterialTheme.shapes.small,
                                keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
                                ),
                                singleLine = true
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Row {
                                IconButton(
                                    onClick = {
                                        val newQuantity = editedQuantity.toIntOrNull() ?: item.quantity
                                        viewModel.updateItemQuantity(index, newQuantity)
                                        isEditingQuantity = false
                                    }
                                ) {
                                    Icon(
                                        Icons.Filled.Save,
                                        contentDescription = "Save",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                IconButton(
                                    onClick = { isEditingQuantity = false }
                                ) {
                                    Icon(
                                        Icons.Filled.Close,
                                        contentDescription = "Cancel",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        } else {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Total: ${item.quantity}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                IconButton(
                                    onClick = { isEditingQuantity = true }
                                ) {
                                    Icon(
                                        Icons.Filled.Edit,
                                        contentDescription = "Edit Quantity",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    } else {
                        Text(
                            text = item.itemName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.description.ifEmpty { "No description" },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                // Animated Status Badge
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                        initialOffsetY = { -it / 2 },
                        animationSpec = spring(dampingRatio = 0.8f, stiffness = 300f)
                    )
                ) {
                    Surface(
                        color = completionColor,
                        shape = MaterialTheme.shapes.small
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = if (isCompleted) Icons.Filled.CheckCircle else Icons.Filled.Pending,
                                contentDescription = if (isCompleted) "Completed" else "Pending",
                                tint = completionTextColor,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isCompleted) "Complete" else "Pending",
                                style = MaterialTheme.typography.bodySmall,
                                color = completionTextColor,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            // Quantity Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivered:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Medium
                )
                
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Enhanced Decrease Button
                    AnimatedStepperButton(
                        onClick = { 
                            if (item.deliveredQuantity > 0) {
                                onQuantityChange(item.deliveredQuantity - 1)
                            }
                        },
                        enabled = item.deliveredQuantity > 0,
                        icon = Icons.Filled.Remove,
                        contentDescription = "Decrease",
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    
                    Spacer(modifier = Modifier.width(20.dp))
                    
                    // Manual Quantity Input
                    var manualInput by remember { mutableStateOf(item.deliveredQuantity.toString()) }
                    var isInputValid by remember { mutableStateOf(true) }
                    
                    LaunchedEffect(item.deliveredQuantity) {
                        manualInput = item.deliveredQuantity.toString()
                    }
                    
                    OutlinedTextField(
                        value = manualInput,
                        onValueChange = { input ->
                            manualInput = input
                            val newQuantity = input.toIntOrNull()
                            if (newQuantity != null && newQuantity >= 0 && newQuantity <= item.quantity) {
                                isInputValid = true
                                onQuantityChange(newQuantity)
                            } else {
                                isInputValid = false
                            }
                        },
                        label = { Text("Qty") },
                        modifier = Modifier.width(80.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = if (isInputValid) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
                            unfocusedBorderColor = if (isInputValid) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.error,
                            focusedLabelColor = if (isInputValid) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        ),
                        shape = MaterialTheme.shapes.small,
                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                            keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
                        ),
                        singleLine = true
                    )
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Text(
                        text = "/${item.quantity}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Spacer(modifier = Modifier.width(20.dp))
                    
                    // Enhanced Increase Button
                    AnimatedStepperButton(
                        onClick = { 
                            if (item.deliveredQuantity < item.quantity) {
                                onQuantityChange(item.deliveredQuantity + 1)
                            }
                        },
                        enabled = item.deliveredQuantity < item.quantity,
                        icon = Icons.Filled.Add,
                        contentDescription = "Increase",
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedStepperButton(
    onClick: () -> Unit,
    enabled: Boolean,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    contentDescription: String,
    containerColor: androidx.compose.ui.graphics.Color,
    contentColor: androidx.compose.ui.graphics.Color
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    // Animate scale on press
    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.9f else 1f,
        animationSpec = spring(
            dampingRatio = 0.8f,
            stiffness = 400f
        ),
        label = "scale"
    )
    
    // Animate elevation on press
    val elevation by animateFloatAsState(
        targetValue = if (isPressed && enabled) 8f else 2f,
        animationSpec = spring(
            dampingRatio = 0.8f,
            stiffness = 400f
        ),
        label = "elevation"
    )
    
    // Animate alpha for disabled state
    val alpha by animateFloatAsState(
        targetValue = if (enabled) 1f else 0.5f,
        animationSpec = tween(200),
        label = "alpha"
    )
    
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .size(44.dp)
            .scale(scale),
        containerColor = containerColor,
        contentColor = contentColor,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = elevation.dp),
        interactionSource = interactionSource
    ) {
        Icon(
            icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(20.dp)
                .graphicsLayer(alpha = alpha)
        )
    }
} 
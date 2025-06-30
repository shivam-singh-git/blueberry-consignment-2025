package com.example.modernandroidapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.modernandroidapp.ui.viewmodels.HomeViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Pending
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.spring
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.scale
import com.example.modernandroidapp.ui.theme.status_completed
import com.example.modernandroidapp.ui.theme.status_pending

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onConsignmentClick: (String) -> Unit
) {
    val consignments by viewModel.ongoingConsignments.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Modern Header
            Column(
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Active Consignments",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${consignments.size} ongoing deliveries",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        if (consignments.isEmpty()) {
            item {
                ModernEmptyState()
            }
        } else {
            items(
                items = consignments,
                key = { it.id }
            ) { consignment ->
                ModernConsignmentCard(
                    consignment = consignment,
                    onConsignmentClick = onConsignmentClick
                )
            }
        }
    }
}

@Composable
fun ModernConsignmentCard(
    consignment: com.example.modernandroidapp.data.Consignment,
    onConsignmentClick: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 400f),
        label = "cardScale"
    )
    
    val elevation by animateFloatAsState(
        targetValue = if (isPressed) 2f else 4f,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 400f),
        label = "cardElevation"
    )
    
    Surface(
        onClick = { onConsignmentClick(consignment.id) },
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = elevation.dp,
        shadowElevation = elevation.dp,
        interactionSource = interactionSource
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            // Header with customer name and status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = consignment.customerName,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${consignment.items.size} items",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                // Modern status badge
                ModernStatusBadge(consignment = consignment)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Progress indicator
            ModernProgressIndicator(consignment = consignment)
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Items preview
            ModernItemsPreview(items = consignment.items.take(3))
        }
    }
}

@Composable
fun ModernStatusBadge(consignment: com.example.modernandroidapp.data.Consignment) {
    val isCompleted = consignment.items.all { it.delivered }
    val completedItems = consignment.items.count { it.delivered }
    
    val statusInfo = when {
        isCompleted -> StatusInfo(
            backgroundColor = status_completed,
            textColor = MaterialTheme.colorScheme.onPrimary,
            icon = Icons.Filled.CheckCircle,
            text = "Complete"
        )
        completedItems > 0 -> StatusInfo(
            backgroundColor = status_pending,
            textColor = MaterialTheme.colorScheme.onPrimary,
            icon = Icons.Filled.Schedule,
            text = "In Progress"
        )
        else -> StatusInfo(
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
            icon = Icons.Filled.Pending,
            text = "Pending"
        )
    }
    
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = statusInfo.backgroundColor
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = statusInfo.icon,
                contentDescription = statusInfo.text,
                tint = statusInfo.textColor,
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = statusInfo.text,
                style = MaterialTheme.typography.labelMedium,
                color = statusInfo.textColor
            )
        }
    }
}

private data class StatusInfo(
    val backgroundColor: androidx.compose.ui.graphics.Color,
    val textColor: androidx.compose.ui.graphics.Color,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val text: String
)

@Composable
fun ModernProgressIndicator(consignment: com.example.modernandroidapp.data.Consignment) {
    val completedItems = consignment.items.count { it.delivered }
    val totalItems = consignment.items.size
    val progress = if (totalItems > 0) completedItems.toFloat() / totalItems else 0f
    
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Progress",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "$completedItems/$totalItems",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        
        // Modern progress bar
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            shape = RoundedCornerShape(4.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            val animatedProgress by animateFloatAsState(
                targetValue = progress,
                animationSpec = spring(),
                label = "progress"
            )
            
            Box(
                modifier = Modifier
                    .fillMaxWidth(animatedProgress)
                    .fillMaxHeight()
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
    }
}

@Composable
fun ModernItemsPreview(items: List<com.example.modernandroidapp.data.ConsignmentItem>) {
    Column {
        items.forEachIndexed { _, item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.itemName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "${item.deliveredQuantity}/${item.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (item != items.last()) {
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun ModernEmptyState() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Inventory,
            contentDescription = "No consignments",
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.surfaceVariant
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "No Active Consignments",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "When a new consignment is added, it will show up here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}

@Composable
fun ModernStatsCard(title: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
} 
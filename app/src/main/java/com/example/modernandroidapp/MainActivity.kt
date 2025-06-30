package com.example.modernandroidapp
import androidx.navigation.compose.currentBackStackEntryAsState
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import android.util.Log
import com.example.modernandroidapp.ui.theme.ModernAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.modernandroidapp.ui.viewmodels.MainViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import com.example.modernandroidapp.ui.screens.LoginScreen
import com.example.modernandroidapp.ui.screens.AdminDashboardScreen
import com.example.modernandroidapp.ui.screens.StaffDashboardScreen
import com.example.modernandroidapp.data.UserRole
import androidx.compose.runtime.LaunchedEffect
import com.example.modernandroidapp.ui.screens.HomeScreen
import com.example.modernandroidapp.ui.screens.AddConsignmentScreen
import com.example.modernandroidapp.ui.screens.HistoryScreen
import com.example.modernandroidapp.ui.screens.ConsignmentDetailScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        try {
            setContent {
                Log.d("MainActivity", "setContent called")
                ModernAndroidAppTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RealNavApp()
                    }
                }
            }
            Log.d("MainActivity", "setContent completed successfully")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error in setContent", e)
        }
    }
}

sealed class BottomNavTab(val route: String, val label: String, val icon: ImageVector) {
    object Home : BottomNavTab("home", "Home", Icons.Filled.Home)
    object AddConsignment : BottomNavTab("add_consignment", "Add", Icons.Filled.Add)
    object History : BottomNavTab("history", "History", Icons.Filled.History)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleBasedMainScreen(currentUserRole: UserRole, onLogout: () -> Unit) {
    val navController = rememberNavController()
    // Tabs based on role
    val tabs = when (currentUserRole) {
        UserRole.ADMIN -> listOf(
            BottomNavTab.Home,
            BottomNavTab.AddConsignment,
            BottomNavTab.History
        )
        UserRole.STAFF -> listOf(
            BottomNavTab.Home,
            BottomNavTab.History
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Modern minimalist logo
                        Surface(
                            modifier = Modifier.size(32.dp),
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "B",
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Blueberry",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                actions = {
                    ModernLogoutButton(onLogout = onLogout)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        },
        bottomBar = {
            ModernBottomNavigation(
                navController = navController,
                tabs = tabs
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(
                    onConsignmentClick = { consignmentId ->
                        navController.navigate("consignment_detail/$consignmentId")
                    }
                )
            }
            composable("add_consignment") {
                AddConsignmentScreen(
                    onConsignmentAdded = {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
            }
            composable("history") {
                HistoryScreen()
            }
            composable(
                route = "consignment_detail/{consignmentId}",
                arguments = listOf(navArgument("consignmentId") { type = NavType.StringType })
            ) { backStackEntry ->
                val consignmentId = backStackEntry.arguments?.getString("consignmentId") ?: ""
                ConsignmentDetailScreen(
                    consignmentId = consignmentId,
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Composable
fun ModernLogoutButton(onLogout: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 400f),
        label = "logoutScale"
    )
    
    Surface(
        onClick = onLogout,
        modifier = Modifier
            .padding(end = 8.dp)
            .scale(scale),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        interactionSource = interactionSource
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.Logout, 
                contentDescription = "Logout",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Logout",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun ModernBottomNavigation(
    navController: NavHostController,
    tabs: List<BottomNavTab>
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp,
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            tabs.forEach { tab ->
                ModernNavigationItem(
                    tab = tab,
                    isSelected = currentDestination == tab.route,
                    onClick = {
                        if (currentDestination != tab.route) {
                            navController.navigate(tab.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ModernNavigationItem(
    tab: BottomNavTab,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 400f),
        label = "navScale"
    )
    
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) 
            MaterialTheme.colorScheme.primaryContainer 
        else 
            Color.Transparent,
        animationSpec = tween(300),
        label = "navBackgroundColor"
    )
    
    val iconColor by animateColorAsState(
        targetValue = if (isSelected) 
            MaterialTheme.colorScheme.onPrimaryContainer 
        else 
            MaterialTheme.colorScheme.onSurfaceVariant,
        animationSpec = tween(300),
        label = "navIconColor"
    )
    
    Surface(
        onClick = onClick,
        modifier = Modifier
            .scale(scale)
            .size(56.dp),
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor,
        interactionSource = interactionSource
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = tab.icon,
                contentDescription = tab.label,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun RealNavApp() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel()
    val isLoggedIn by viewModel.isLoggedIn.collectAsStateWithLifecycle()
    val currentUserRole by viewModel.currentUserRole.collectAsStateWithLifecycle()

    android.util.Log.d("RealNavApp", "isLoggedIn=$isLoggedIn, currentUserRole=$currentUserRole")

    LaunchedEffect(isLoggedIn, currentUserRole) {
        if (!isLoggedIn) {
            navController.navigate("login") {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn && currentUserRole != null) "main" else "login"
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { /* Navigation handled by LaunchedEffect */ }
            )
        }
        composable("main") {
            if (isLoggedIn && currentUserRole != null) {
                RoleBasedMainScreen(currentUserRole!!, onLogout = { viewModel.logout() })
            }
        }
    }
}

@Composable
fun PlaceholderScreen(title: String, color: Color, buttonText: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = color
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                color = Color.Black,
                fontSize = 32.sp,
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = onClick,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(buttonText)
            }
        }
    }
} 
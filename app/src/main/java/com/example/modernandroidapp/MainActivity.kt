package com.example.modernandroidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.modernandroidapp.data.UserRole
import com.example.modernandroidapp.ui.screens.AddConsignmentScreen
import com.example.modernandroidapp.ui.screens.ConsignmentDetailScreen
import com.example.modernandroidapp.ui.screens.HistoryScreen
import com.example.modernandroidapp.ui.screens.HomeScreen
import com.example.modernandroidapp.ui.screens.LoginScreen
import com.example.modernandroidapp.ui.theme.ModernAndroidAppTheme
import com.example.modernandroidapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleBasedMainScreen(currentUserRole: UserRole, onLogout: () -> Unit) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                    IconButton(onClick = onLogout) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Logout",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                userRole = currentUserRole,
                currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
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
                    },
                    onLogout = onLogout
                )
            }
        }
    }
}

@Composable
fun RealNavApp() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val isLoggedIn by viewModel.isLoggedIn.collectAsStateWithLifecycle()
    val currentUserRole by viewModel.currentUserRole.collectAsStateWithLifecycle()

    Log.d("RealNavApp", "isLoading=$isLoading, isLoggedIn=$isLoggedIn, currentUserRole=$currentUserRole")

    if (isLoading) {
        LoadingScreen()
        return
    }

    LaunchedEffect(isLoggedIn) {
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
                onLoginSuccess = {
                    // After login, navigate to main and clear back stack
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("main") {
            if (isLoggedIn && currentUserRole != null) {
                RoleBasedMainScreen(currentUserRole = currentUserRole!!, onLogout = { viewModel.logout() })
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    val scale = remember { Animatable(0.5f) }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = androidx.compose.animation.core.FastOutSlowInEasing
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.blueberry_logo),
            contentDescription = "Loading Logo",
            modifier = Modifier
                .size(150.dp)
                .scale(scale.value)
        )
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

@Composable
fun BottomNavigationBar(
    navController: NavController,
    userRole: UserRole,
    currentRoute: String?
) {
    val navigationItems = when (userRole) {
        UserRole.ADMIN -> listOf(
            NavigationItem.Home,
            NavigationItem.AddConsignment,
            NavigationItem.History
        )
        UserRole.STAFF -> listOf(
            NavigationItem.Home,
            NavigationItem.History
        )
    }

    if (navigationItems.isNotEmpty()) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            tonalElevation = 8.dp
        ) {
            navigationItems.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    )
                )
            }
        }
    }
}

sealed class NavigationItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object AddConsignment : NavigationItem("add_consignment", Icons.Default.Add, "Add")
    object History : NavigationItem("history", Icons.Default.History, "History")
}
package com.example.modernandroidapp.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object AdminDashboard : Screen("admin_dashboard")
    object StaffDashboard : Screen("staff_dashboard")
}

object NavGraph {
    const val ROOT_ROUTE = "root"
} 
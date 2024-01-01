package com.example.demomarketapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem ("home", Icons.Default.Home, "Home")
    object Search : BottomNavItem ("search", Icons.Default.Search, "Search")
    // dan seterusnya untuk item lainnya
}
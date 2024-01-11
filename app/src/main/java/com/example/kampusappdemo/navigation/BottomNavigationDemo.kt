package com.example.kampusappdemo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Reorder
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationDemo(
    val route: String = "",
    val icon: ImageVector  = Icons.Default.Home,
    val label: String = ""
) {
    fun BottomNavItemDemo(): List<BottomNavigationDemo> {
        return listOf(
            BottomNavigationDemo(Screens.Home.route, Icons.Default.Home, "Home"),
            BottomNavigationDemo(Screens.Search.route, Icons.Default.Explore, "Explore"),
            BottomNavigationDemo(Screens.Booking.route, Icons.Default.Reorder, "Booking"),
            BottomNavigationDemo(Screens.Bookmark.route, Icons.Default.Bookmarks, "Saved"),
            BottomNavigationDemo(Screens.Profile.route, Icons.Default.AccountCircle, "Profile")
        )

    }
}
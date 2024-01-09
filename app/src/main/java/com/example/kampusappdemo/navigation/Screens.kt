package com.example.kampusappdemo.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Search : Screens("explore")
    object Detail : Screens("detail")
    object Booking : Screens("booking")
    object Bookmark : Screens("bookmark")
    object Profile : Screens("profile")

    object Setting : Screens("setting")

}

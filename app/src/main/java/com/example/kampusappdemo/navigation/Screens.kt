package com.example.kampusappdemo.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Search : Screens("explore")
    object Detail : Screens("detail?&index={index}") {
        fun createRoute(
            index : Int?,
        ): String {
            return "detail?&index=${index}"
        }
    }
    object Booking : Screens("booking")
    object Payment : Screens("payment?&name={name}&city={city}&image={image}&type={type}") {
        fun createRoute(
            name: String?,
            city: String?,
            image: Int?,
            type: String?
        ): String {
            return "payment?&name=${name}&city=${city}&image=${image}&type=${type}"
        }
    }

    object Bookmark : Screens("bookmark")
    object Profile : Screens("profile")
    object Setting : Screens("setting")
    object Chat : Screens("chat")
}

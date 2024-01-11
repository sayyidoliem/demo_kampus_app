package com.example.kampusappdemo.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Search : Screens("explore")
    object Detail : Screens("detail?&name={name}&city={city}&image={image}&desc={desc}") {
        fun createRoute(
            name: String?,
            city: String?,
            image: Int?,
            desc: String?
        ): String {
            return "detail?&name=${name}&city=${city}&image=${image}&desc=${desc}"
        }
    }

    object Booking : Screens("booking")
    object Payment : Screens("payment")
    object Bookmark : Screens("bookmark")
    object Profile : Screens("profile")
    object Setting : Screens("setting")
    object Chat : Screens("chat")
}

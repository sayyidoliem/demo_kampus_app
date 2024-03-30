package com.example.kampusappdemo.navigation

sealed class Screens(val route: String) {
    object Splash : Screens("splash")
    object TypeUserSignUp : Screens("typeUserSignUp")
    object SignUpStudent : Screens("signUpStudent")
    object SignUpInstance : Screens("signUpInstance")
    object SignIn : Screens("signIn")
    object Home : Screens("home")
    object Search : Screens("explore")
    object Detail : Screens("detail?&index={index}") {
        fun createRoute(
            index: Int?,
        ): String {
            return "detail?&index=${index}"
        }
    }
    object Comparison : Screens("comparison?&index={index}"){
        fun createRoute(
            index : Int?,
        ): String{
            return "comparison?&index=${index}"
        }
    }
    object Booking : Screens("booking")
    object Dashboard : Screens("dashboard")
    object DetailDashboard : Screens("detailDashboard?&index={index}"){
        fun createRoute(
            index : Int?,
        ): String{
            return "detailDashboard?&index=${index}"
        }
    }
    object Payment : Screens("payment?&index={index}") {
        fun createRoute(
            index: Int?,
        ): String {
            return "payment?&index=${index}"
        }
    }
    object Bookmark : Screens("bookmark")
    object Statistic : Screens("statistic")
    object Profile : Screens("profile")
    object Setting : Screens("setting")
    object ChatUser : Screens("chatUser")
    object ListChatUser : Screens("listChatUser")
    object ChatAdmin : Screens("chatAdmin")
    object ListChatAdmin : Screens("listChatAdmin")
    object NeedSignIn :Screens("needSignIn")
}

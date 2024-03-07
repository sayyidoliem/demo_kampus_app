package com.example.kampusappdemo.navigation

sealed class Screens(val route: String) {
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

    object Booking : Screens("booking")
    object Payment : Screens("payment?&index={index}") {
        fun createRoute(
            index: Int?,
        ): String {
            return "payment?&index=${index}"
        }
    }

    object Bookmark : Screens("bookmark")
    object Profile :
        Screens("profile?&name={name}&phone={phone}&email={email}&nameInstance={nameInstance}&studyProgram={studyProgram}&city={city}&province={province}") {
        fun createRoute(
            name: String?,
            phone: String?,
            email: String?,
            nameInstance: String?,
            studyProgram: String?,
            city: String?,
            province: String?
        ): String {
            return "profile?&name=${name}&phone=${phone}&email=${email}&nameInstance=${nameInstance}&studyProgram=${studyProgram}&city=${city}&province=${province}"
        }
    }

    object Setting : Screens("setting")
    object Chat : Screens("chat")
}

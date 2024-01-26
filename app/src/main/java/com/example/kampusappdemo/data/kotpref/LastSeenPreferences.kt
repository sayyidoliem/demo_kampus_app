package com.example.kampusappdemo.data.kotpref


import com.chibatching.kotpref.KotprefModel

object LastSeenPreferences : KotprefModel() {
    var index by intPref(-1)
    var instance by stringPref("")
    var name by stringPref("")
    var image by stringPref("")
    var rating by floatPref(-1F)
    var city by stringPref("")
    var province by stringPref("")

}
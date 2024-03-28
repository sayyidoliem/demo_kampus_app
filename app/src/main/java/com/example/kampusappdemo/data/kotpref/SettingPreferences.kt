package com.example.kampusappdemo.data.kotpref

import com.chibatching.kotpref.KotprefModel

object SettingPreferences : KotprefModel() {
    //buat ganti tranlate
    const val ENGLISH = 0
    const val INDONESIA = 1

    private const val LIGHT_MODE = false

    var isSelectedLanguage by intPref(0)

    var isDarkMode by booleanPref(false)

    var isOnBoarding by booleanPref(true)

    var typeUser by intPref(0)

    const val GUEST = 0
    const val USER = 1
    const val ADMIN = 2
}
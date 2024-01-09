package com.example.kampusappdemo.data.kotpref

import com.chibatching.kotpref.KotprefModel

object SettingPreferences : KotprefModel() {
    //buat ganti tranlate
    const val ENGLISH = 0
    const val INDONESIA = 1

    private const val LIGHT_MODE = false

    const val FOCUS_READ = false

    var isSelectedLanguage by intPref(
        ENGLISH
    )

    var isDarkMode by booleanPref(
        LIGHT_MODE
    )

    var dateFormat by longPref(-1)

    var isOnBoarding by booleanPref(true)

}
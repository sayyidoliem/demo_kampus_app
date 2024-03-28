package com.example.kampusappdemo.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.kampusappdemo.data.kotpref.SettingPreferences

object GlobalState {
    var isDarkMode by mutableStateOf(SettingPreferences.isDarkMode)

    var isOnBoarding by mutableStateOf(SettingPreferences.isOnBoarding)
}
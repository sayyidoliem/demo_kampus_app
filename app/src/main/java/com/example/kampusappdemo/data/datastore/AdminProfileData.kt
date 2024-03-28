package com.example.kampusappdemo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AdminProfileData {
    companion object {
        val USER_INSTANCE_KEY = stringPreferencesKey("admin_instance")
        val USER_PROGRAM_KEY = stringPreferencesKey("admin_program")
        val USER_CITY_KEY = stringPreferencesKey("admin_city")
        val USER_PROVINCE_KEY = stringPreferencesKey("admin_province")
    }
}
package com.example.kampusappdemo.data.local.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

class AdminProfileKey {
    companion object {
        val USER_INSTANCE_KEY = stringPreferencesKey("admin_instance")
        val USER_PROGRAM_KEY = stringPreferencesKey("admin_program")
        val USER_CITY_KEY = stringPreferencesKey("admin_city")
        val USER_PROVINCE_KEY = stringPreferencesKey("admin_province")
    }
}
package com.example.kampusappdemo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

class UserProfileData() {
    companion object {
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val USER_PHONE_KEY = stringPreferencesKey("user_phone")
        val USER_PASSWORD_KEY = stringPreferencesKey("user_password")
    }
}



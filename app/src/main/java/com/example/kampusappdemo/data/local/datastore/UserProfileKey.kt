package com.example.kampusappdemo.data.local.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

class UserProfileKey() {
    companion object {
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val USER_PHONE_KEY = stringPreferencesKey("user_phone")
        val USER_PASSWORD_KEY = stringPreferencesKey("user_password")
    }
}



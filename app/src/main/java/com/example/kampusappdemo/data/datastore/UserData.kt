package com.example.kampusappdemo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserData (private val  context: Context){

    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user")
    }

    //get method
    val getUserName : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[UserProfileData.USER_NAME_KEY] ?: "name"
    }

    //save or update
    suspend fun saveUserName(name : String){
        context.dataStore.edit { preferences ->
            preferences[UserProfileData.USER_NAME_KEY] = name
        }
    }

    //get method
    val getUserEmail : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[UserProfileData.USER_EMAIL_KEY] ?: "name@email.com"
    }

    //save or update
    suspend fun saveUserEmail(email : String){
        context.dataStore.edit { preferences ->
            preferences[UserProfileData.USER_EMAIL_KEY] = email
        }
    }

    //get method
    val getUserPhone : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[UserProfileData.USER_PHONE_KEY] ?: "+1 234 567"
    }

    //save or update
    suspend fun saveUserPhone(phone : String){
        context.dataStore.edit { preferences ->
            preferences[UserProfileData.USER_PHONE_KEY] = phone
        }
    }

    //get method
    val getUserPassword : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[UserProfileData.USER_PASSWORD_KEY] ?: "123"
    }

    //save or update
    suspend fun saveUserPassword(password : String){
        context.dataStore.edit { preferences ->
            preferences[UserProfileData.USER_PASSWORD_KEY] = password
        }
    }


    //get method
    val getUserNameInstance : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[AdminProfileData.USER_INSTANCE_KEY] ?: "university"
    }

    //save or update
    suspend fun saveUserNameInstance(instance : String){
        context.dataStore.edit { preferences ->
            preferences[AdminProfileData.USER_INSTANCE_KEY] = instance
        }
    }

    //get method
    val getUserProgram : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[AdminProfileData.USER_PROGRAM_KEY] ?: "study program"
    }

    //save or update
    suspend fun saveUserProgram(program : String){
        context.dataStore.edit { preferences ->
            preferences[AdminProfileData.USER_PROGRAM_KEY] = program
        }
    }

    //get method
    val getUserCity : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[AdminProfileData.USER_CITY_KEY] ?: "Jakarta"
    }

    //save or update
    suspend fun saveUserCity(city : String){
        context.dataStore.edit { preferences ->
            preferences[AdminProfileData.USER_CITY_KEY] = city
        }
    }

    //get method
    val getUserProvince : Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[AdminProfileData.USER_PROVINCE_KEY] ?: "Jawa Barat"
    }

    //save or update
    suspend fun saveUserProvince(province : String){
        context.dataStore.edit { preferences ->
            preferences[AdminProfileData.USER_PROVINCE_KEY] = province
        }
    }
}
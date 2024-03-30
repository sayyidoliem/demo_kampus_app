package com.example.kampusappdemo.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ComparisonData(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("comparison")
    }

    //get method
    val getIndex1: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[ComparisonKey.INDEX_KEY_1] ?: 0
    }

    //save or update
    suspend fun saveIndex1(index: Int) {
        context.dataStore.edit { preferences ->
            preferences[ComparisonKey.INDEX_KEY_1] = index
        }
    }

    //get method
    val getIndex2: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[ComparisonKey.INDEX_KEY_2] ?: 0
    }

    //save or update
    suspend fun saveIndex2(index: Int) {
        context.dataStore.edit { preferences ->
            preferences[ComparisonKey.INDEX_KEY_2] = index
        }
    }

    //get method
    val getIndex3: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[ComparisonKey.INDEX_KEY_3] ?: 0
    }

    //save or update
    suspend fun saveIndex3(index: Int) {
        context.dataStore.edit { preferences ->
            preferences[ComparisonKey.INDEX_KEY_3] = index
        }
    }

    //get method
    val getIndex4: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[ComparisonKey.INDEX_KEY_1] ?: 0
    }

    //save or update
    suspend fun saveIndex4(index: Int) {
        context.dataStore.edit { preferences ->
            preferences[ComparisonKey.INDEX_KEY_4] = index
        }
    }
}

class ComparisonKey{
    companion object{
        val INDEX_KEY_1 = intPreferencesKey("index1")
        val INDEX_KEY_2 = intPreferencesKey("index2")
        val INDEX_KEY_3 = intPreferencesKey("index3")
        val INDEX_KEY_4 = intPreferencesKey("index4")
    }
}
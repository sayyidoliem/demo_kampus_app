package com.example.kampusappdemo.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class BookmarkData(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("bookmark")
    }

    //get method
    val getIndex: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[BookmarkKey.INDEX_KEY] ?: 0
    }

    //save or update
    suspend fun saveIndex(index: Int) {
        context.dataStore.edit { preferences ->
            preferences[BookmarkKey.INDEX_KEY] = index
        }
    }
}

class BookmarkKey{
    companion object{
        val INDEX_KEY = intPreferencesKey("index")
    }
}
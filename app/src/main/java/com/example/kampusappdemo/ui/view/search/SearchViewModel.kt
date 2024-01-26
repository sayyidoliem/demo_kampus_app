package com.example.kampusappdemo.ui.view.search

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class SearchViewModel() : ViewModel() {

    //first state whether the search is happening or not
    val isSearching = MutableStateFlow(false)

    fun onToogleSearch() {
        isSearching.value = !isSearching.value
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {//for get local json
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun dataList(context: Context): MutableList<EducationData> {//get content from val getjson and use education object
        val jsonFileString = getJsonDataFromAsset(context = context, "data.json")
        val type = object : TypeToken<List<EducationData>>() {}.type
        return Gson().fromJson(jsonFileString, type)
    }

    fun filterDataBySearch(data: List<EducationData>, name: String): MutableList<EducationData> {
        return data.filter {
            it.name.contains(name, ignoreCase = true)
                    || it.instance.contains(name, ignoreCase = true)
                    || it.location.city.contains(name, ignoreCase = true)
                    || it.location.province.contains(name, ignoreCase = true)
        }.toMutableList()
    }
}
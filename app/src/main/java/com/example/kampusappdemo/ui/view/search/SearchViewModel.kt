package com.example.kampusappdemo.ui.view.search

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
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
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    //second state the text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onToogleSearch() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChange("")
        }
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {//for get local json
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
//        val data = dataList(context)context: Context,
        return data.filter {
            it.name == name || it.instance == name || it.location.city == name || it.location.province == name
        }.toMutableList()
    }

//    //third state the list to be filtered
//    private val _countriesList = MutableStateFlow(countries)
//    val countriesList = searchText
//        .combine(_countriesList) { text, countries ->//combine searchText with _contriesList
//            if (text.isBlank()) { //return the entery list of countries if not is typed
//                countries
//            }
//            countries.filter { country ->// filter and return a list of countries based on the text the user typed
//                country.uppercase().contains(text.trim().uppercase())
//            }
//        }.stateIn(//basically convert the Flow returned from combine operator to StateFlow
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),//it will allow the StateFlow survive 5 seconds before it been canceled
//            initialValue = _countriesList.value
//        )
}
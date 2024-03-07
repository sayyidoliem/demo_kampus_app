package com.example.kampusappdemo.module.user.feature.search.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.IOException

class SearchViewModel() : ViewModel() {

    var textQuery by mutableStateOf("")
        private set

    fun updateTextQuery(input : String){
        textQuery = input
    }

    val isSearching = MutableStateFlow(false)

    fun onToogleSearch() {
        isSearching.value = !isSearching.value
    }

    var isFilter by mutableStateOf(false)

    fun onToogleFilter(){
        isFilter= !isFilter
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
                    || it.studyProgram.contains(name, ignoreCase = true)
                    || it.location.city.contains(name, ignoreCase = true)
                    || it.location.province.contains(name, ignoreCase = true)
                    || it.name.contains(name, ignoreCase = true) && it.studyProgram.contains(name, ignoreCase = true)
        }.toMutableList()
    }

    data class FilterChipCity(val cities: List<String>)

    fun dataLdist(context: Context): MutableList<FilterChipCity> {
        val jsonFileString = getJsonDataFromAsset(context = context, "data.json")
        val type = object : TypeToken<List<EducationData>>() {}.type
        return Gson().fromJson(jsonFileString, type)
    }
}
package com.example.kampusappdemo.module.user.feature.comparison.viewmodel

import android.content.Context
import androidx.collection.MutableIntList
import androidx.collection.mutableIntListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.IOException

class ComparisonViewModel : ViewModel() {

    var textQuery by mutableStateOf("")
        private set

    fun updateTextQuery(input : String){
        textQuery = input
    }

    val isSearching = MutableStateFlow(false)

    fun onToggleSearch() {
        isSearching.value = !isSearching.value
    }

    val comparisonList: MutableIntList =  mutableIntListOf()

    fun addComparison(input : Int){
        comparisonList.add(input)
    }

    fun deleteComparison(){
        comparisonList.clear()
    }

    var openAddDialog = mutableStateOf(false)

    fun showAddDialog() {
        openAddDialog.value = true
    }
    fun hideAddDialog() {
        openAddDialog.value = false
    }

    var openDeleteDialog = mutableStateOf(false)

    fun showDeleteDialog() {
        openDeleteDialog.value = true
    }
    fun hideDeleteDialog() {
        openDeleteDialog.value = false
    }

    var openDetailDialog = mutableStateOf(false)

    fun showDetailDialog() {
        openDetailDialog.value = true
    }
    fun hideDetailDialog() {
        openDetailDialog.value = false
    }
    private fun getJsonDataFromAsset(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun dataList(context: Context): MutableList<EducationData> {
        val jsonFileString = getJsonDataFromAsset(context = context)
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
                    || it.name.contains(name, ignoreCase = true) && it.studyProgram.contains(
                name,
                ignoreCase = true
            )
        }.toMutableList()
    }

    fun filterDataByIndex(context: Context, index: Any): List<EducationData> {
        val data = dataList(context)
        return data.filter { it.id == index }
    }
}
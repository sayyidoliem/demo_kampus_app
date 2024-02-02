package com.example.kampusappdemo.feature.detail.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DetailViewmodel : ViewModel() {

    var openSuccessDialog = mutableStateOf(false)

    var openConfirmation = mutableStateOf(false)

    var searchBar = mutableStateOf(false)

    var checkedBox = mutableStateOf(false)

    var registerEnabled = mutableStateOf(false)

    var ppp = University.values()

    fun showSuccessDialog() {
        openSuccessDialog.value = true
    }

    fun hideSuccessDialog() {
        openSuccessDialog.value = false
    }

    fun showConfirmationDialog() {
        openConfirmation.value = true
    }

    fun hideConfirmationDialog() {
        openConfirmation.value = false
    }

    fun enabledRegister() {
        openConfirmation.value = true
    }

    fun disableRegister() {
        openConfirmation.value = false
    }

    fun enabledCheckBox() {
        checkedBox.value = true
    }

    fun disabledCheckBox() {
        checkedBox.value = false
    }

    fun openSearchBar(){
        searchBar.value = true
    }

    fun closeSearchBar(){
        searchBar.value = false
    }

    private fun getJsonDataFromAsset(context: Context): String? {//for get local json
        val jsonString: String
        try {
            jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
    fun dataAtIndex(context: Context, index: Int): EducationData? {
        val jsonFileString = getJsonDataFromAsset(context = context)
        val type = object : TypeToken<List<EducationData>>() {}.type
        val dataList: List<EducationData> = Gson().fromJson(jsonFileString, type)

        // check if index valid
        return try {
            index in dataList.indices
            dataList[index]
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }

}
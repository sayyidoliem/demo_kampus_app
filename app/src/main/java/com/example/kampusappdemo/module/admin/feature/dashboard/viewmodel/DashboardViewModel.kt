package com.example.kampusappdemo.module.admin.feature.dashboard.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DashboardViewModel : ViewModel() {

    var openAddDialog = mutableStateOf(false)

    fun showDialog() {
        openAddDialog.value = true
    }

    fun hideDialog() {
        openAddDialog.value = false
    }

    var openConfirmationDialog = mutableStateOf(false)

    fun showConfirmationDialog(){
        openConfirmationDialog.value = true
    }

    fun hideConfirmationDialog(){
        openConfirmationDialog.value = false
    }

    var enabled = mutableStateOf(true)

    fun enabledMySchool(){
        enabled.value = true
    }
    fun disableMySchool(){
        enabled.value = false
    }

    val studyProgramOptions = listOf("General", "Specific")

    var studyProgramDialog = mutableStateOf(false)

    fun isStudyProgramDialogOpen() {
        studyProgramDialog.value = true
    }

    fun isStudyProgramDialogClose() {
        studyProgramDialog.value = false
    }

    var imageDialog = mutableStateOf(false)

    fun isImageDialogOpen() {
        imageDialog.value = true
    }

    fun isImageDialogClose() {
        imageDialog.value = false
    }

    var schoolName by mutableStateOf("")
        private set

    fun updateUser(input: String) {
        schoolName = input
    }

    var phone by mutableStateOf("")
        private set

    fun updatePhone(input: String) {
        phone = input
    }

    var email by mutableStateOf("")
        private set

    fun updateEmail(input: String) {
        email = input
    }

    var instance by mutableStateOf("")
        private set

    fun updateInstance(input: String) {
        instance = input
    }

    var city by mutableStateOf("")
        private set

    fun updateCity(input: String) {
        city = input
    }

    var province by mutableStateOf("")
        private set

    fun updateProvince(input: String) {
        province = input
    }

    var description by mutableStateOf("")
        private set

    fun updateDescription(input: String) {
        description = input
    }

    var requirement by mutableStateOf("")
        private set

    fun updateRequirement(input: String) {
        requirement = input
    }

    var termsCondition by mutableStateOf("")
        private set

    fun updateTermsCondition(input: String) {
        termsCondition = input
    }

    var registration by mutableStateOf("")
        private set

    fun updateRegistration(input: String) {
        registration = input
    }

    var visit by mutableStateOf("")
        private set

    fun updateVisit(input: String) {
        visit = input
    }

    var teleconsultation by mutableStateOf("")
        private set

    fun updateteleconsultation(input: String) {
        teleconsultation = input
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

    fun dataList(context: Context): MutableList<EducationData> {//get content from val getjson and use education object
        val jsonFileString = getJsonDataFromAsset(context = context)
        val type = object : TypeToken<List<EducationData>>() {}.type
        return Gson().fromJson(jsonFileString, type)
    }

    fun filterDataByLastAdd(context: Context): List<EducationData> {
        val data = dataList(context)
        return data.filter { it.id == 8 }
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
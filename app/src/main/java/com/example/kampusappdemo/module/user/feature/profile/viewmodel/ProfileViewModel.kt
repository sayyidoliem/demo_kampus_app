package com.example.kampusappdemo.module.user.feature.profile.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    var name by mutableStateOf("Guest")
    var phone by mutableStateOf("12345")
    var email by mutableStateOf("email@gmail.com")
    var nameInstance by mutableStateOf("")
    var studyProgram by mutableStateOf("")
    var city by mutableStateOf("")
    var province by mutableStateOf("")
    var document by mutableStateOf("document.pdf")

    fun updateName(newName: String) {
        if (newName.isNotEmpty()) {
            name = newName
        }
    }

    fun updatePhone(newPhone: String) {
        if (newPhone.isNotEmpty()) {
            phone = newPhone
        }
    }

    fun updateEmail(newEmail: String) {
        if (newEmail.isNotEmpty()) {
            email = newEmail
        }
    }

    fun updateNameInstance(newNameInstance: String) {
        if (newNameInstance.isNotEmpty()) {
            nameInstance = newNameInstance
        }
    }

    fun updateStudyProgram(newStudyProgram: String) {
        if (newStudyProgram.isNotEmpty()) {
            studyProgram = newStudyProgram
        }
    }

    fun updateCity(newCity: String) {
        if (newCity.isNotEmpty()) {
            city = newCity
        }
    }

    fun updateProvince(newProvince: String) {
        if (newProvince.isNotEmpty()) {
            province = newProvince
        }
    }

    var openEditDialog = mutableStateOf(false)
    fun showDialog() {
        openEditDialog.value = true
    }

    fun hideDialog() {
        openEditDialog.value = false
    }

    var openConfirmationDialog = mutableStateOf(false)
    fun showConfirmationDialog(){
        openConfirmationDialog.value = true
    }
    fun hideConfirmationDialog(){
        openConfirmationDialog.value = false
    }

    var openDocumentDialog = mutableStateOf(false)
    fun showDocumentDialog(){
        openDocumentDialog.value = true
    }
    fun hideDocumentDialog(){
        openDocumentDialog.value = false
    }
}
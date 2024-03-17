package com.example.kampusappdemo.module.guest.feature.login.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val list = listOf("Student", "Instance/College")

    val studyProgramOptions = listOf("General", "Specific")
    var user by mutableStateOf("")
        private set

    fun updateUser(input: String) {
        user = input
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

    var password by mutableStateOf("")
        private set

    fun updatePassword(input: String) {
        password = input
    }

    var confirmPassword by mutableStateOf("")
        private set

    fun updateConfirmPassword(input: String) {
        confirmPassword = input
    }

    var phone by mutableStateOf("")
        private set

    fun updatePhone(input: String) {
        phone = input
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

    var prodi by mutableStateOf("")
        private set

    fun updateProdi(input: String) {
        prodi = input
    }

    var imageDialog = mutableStateOf(false)

    fun isImageDialogOpen() {
        imageDialog.value = true
    }

    fun isImageDialogClose() {
        imageDialog.value = false
    }

    var studyProgramDialog = mutableStateOf(false)

    fun isStudyProgramDialogOpen() {
        studyProgramDialog.value = true
    }

    fun isStudyProgramDialogClose() {
        studyProgramDialog.value = false
    }

    fun isSignUpStudentConfirmed(): Boolean {
        return password == confirmPassword
                && user.isNotEmpty()
                && email.isNotEmpty()
                && phone.isNotEmpty()
    }

    fun isSignUpInstanceConfirmed(): Boolean {
        return password == confirmPassword
                && user.isNotEmpty()
                && email.isNotEmpty()
                && city.isNotEmpty()
                && province.isNotEmpty()
                && instance.isNotEmpty()
                && phone.isNotEmpty()
    }

}
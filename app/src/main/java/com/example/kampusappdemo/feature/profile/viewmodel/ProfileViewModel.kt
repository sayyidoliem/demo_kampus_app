package com.example.kampusappdemo.feature.profile.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel :ViewModel() {

    var openEditDialog = mutableStateOf(false)

    fun showDialog() {
        openEditDialog.value = true
    }

    fun hideDialog() {
        openEditDialog.value = false
    }

}
package com.example.kampusappdemo.ui.view.profile

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
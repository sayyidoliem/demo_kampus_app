package com.example.kampusappdemo.ui.view.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.data.local.database.University

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

    fun sss() {
        ppp.forEach {
            it.id.toString()
        }
    }

}
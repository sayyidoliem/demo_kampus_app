package com.example.kampusappdemo.module.user.feature.payment.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class PaymentViewModel : ViewModel() {
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

    fun getTotal(context: Context, index: Int): Double {
        val finalDataList = dataAtIndex(context, index)
        val register = finalDataList?.register ?: 0.0
        val visit = finalDataList?.visit ?: 0.0
        val teleConsultation = finalDataList?.teleConsultation ?: 0.0
        return register + visit + teleConsultation
    }
}
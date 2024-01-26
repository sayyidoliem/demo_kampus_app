package com.example.kampusappdemo.ui.view.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.model.EducationData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class HomeViewModel : ViewModel() {
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
    fun dataList(context: Context): MutableList<EducationData> {
        val jsonFileString = getJsonDataFromAsset(context = context, "data.json")
        val type = object : TypeToken<List<EducationData>>() {}.type
        return Gson().fromJson(jsonFileString, type)
    }

    fun filterDataByLastSeen(context: Context): List<EducationData> {
        val data = dataList(context)
        return data.filter { it.id == 8 }
    }
}
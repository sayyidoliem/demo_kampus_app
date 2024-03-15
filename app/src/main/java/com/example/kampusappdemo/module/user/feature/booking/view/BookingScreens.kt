package com.example.kampusappdemo.module.user.feature.booking.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.model.EducationData
import com.example.kampusappdemo.module.user.feature.booking.component.ListItemBookingDemo
import com.example.kampusappdemo.module.user.feature.booking.component.TopAppBarBookingDemo
import com.example.kampusappdemo.module.user.feature.booking.viewmodel.BookingViewModel

@Composable
fun BookingScreens(
    navigate: (index: Int?) -> Unit,
    viewModel: BookingViewModel
) {
    val context = LocalContext.current
    val list = viewModel.dataList(context)

    SettingPreferences.typeUser = SettingPreferences.USER

    Scaffold(
        topBar = {
            TopAppBarBookingDemo()
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(modifier = Modifier
                        .padding(horizontal = 16.dp), onClick = { /*TODO*/ }) {
                        Text(text = "Delete All")
                    }
                }
            }
            items(list) { educationData ->
                ListItemBookingDemo(
                    image = ImageDummy[educationData.id].image,
                    headLineText = educationData.name,
                    supportText = educationData.studyProgram,
                    onClick = {
                        navigate(
                            educationData.id,
                        )
                    }
                )
            }
        }
    }
}
package com.example.kampusappdemo.feature.booking.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.feature.booking.component.ListItemBookingDemo
import com.example.kampusappdemo.feature.booking.component.TopAppBarBookingDemo

@Composable
fun BookingScreens(
    navigate: (name: String?, city: String?, image: Int?, type: String?) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBarBookingDemo()
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End) {
                    TextButton(modifier = Modifier
                        .padding(horizontal = 16.dp), onClick = { /*TODO*/ }) {
                        Text(text = "Delete All")
                    }
                }
            }
            University.values().forEachIndexed { index, university ->
                items(index) {
                    ListItemBookingDemo(
                        image = university.universityImage,
                        headLineText = university.universityName,
                        supportText = university.universityLocation,
                        onClick = {
                            navigate(
                                university.universityName,
                                university.universityLocation,
                                university.universityImage,
                                university.universityType,
                            )
                        }
                    )
                }
            }
        }
    }
}
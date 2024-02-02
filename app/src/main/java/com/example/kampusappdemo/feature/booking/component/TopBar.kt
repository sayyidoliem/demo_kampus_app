package com.example.kampusappdemo.feature.booking.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarBookingDemo() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Booking") },
    )
}
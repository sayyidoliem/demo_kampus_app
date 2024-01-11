package com.example.kampusappdemo.ui.view.booking

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.ui.component.TopAppBarBookingDemo

@Composable
fun BookingScreens() {
    Scaffold(
        topBar = {
            TopAppBarBookingDemo()
        }
    ) {
        it
    }
}
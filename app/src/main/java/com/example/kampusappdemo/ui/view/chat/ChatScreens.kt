package com.example.kampusappdemo.ui.view.chat

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.ui.component.BottomAppBarChatDemo
import com.example.kampusappdemo.ui.component.TopAppBarChatDemo

@Composable
fun ChatScreens(
    navigateUp: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarChatDemo(navigate = { navigateUp() }, onClick = { })
        },
        bottomBar = {
            BottomAppBarChatDemo()
        }
    ) {
        it
    }
}
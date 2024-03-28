package com.example.kampusappdemo.module.user.feature.chat.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.module.user.feature.chat.component.BottomAppBarChatDemo
import com.example.kampusappdemo.module.user.feature.chat.component.TopAppBarChatDemo

@Composable
fun ChatUserScreens(
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
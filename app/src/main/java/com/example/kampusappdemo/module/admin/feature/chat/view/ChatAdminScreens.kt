package com.example.kampusappdemo.module.admin.feature.chat.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.module.admin.feature.chat.component.BottomAppBarChatAdminDemo
import com.example.kampusappdemo.module.admin.feature.chat.component.TopAppBarChatAdminDemo

@Composable
fun ChatAdminScreens(navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBarChatAdminDemo(navigate = { navigateUp() }, onClick = {})
        },
        bottomBar = {
            BottomAppBarChatAdminDemo()
        }
    ) {
        it

    }
}
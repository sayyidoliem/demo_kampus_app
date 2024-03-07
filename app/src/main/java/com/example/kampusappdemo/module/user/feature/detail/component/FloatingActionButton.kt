package com.example.kampusappdemo.module.user.feature.detail.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun FABChat(
    navigate: () -> Unit
) {
    FloatingActionButton(onClick = { navigate() }) {
        Icon(imageVector = Icons.Default.Message, contentDescription = "chat")
    }
}
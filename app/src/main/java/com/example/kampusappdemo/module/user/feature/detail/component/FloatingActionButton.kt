package com.example.kampusappdemo.module.user.feature.detail.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FABChat(
    navigate: () -> Unit
) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { navigate() }) {
        Icon(imageVector = Icons.Default.Message, contentDescription = "chat")
    }
}
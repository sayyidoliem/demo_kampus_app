package com.example.kampusappdemo.feature.home.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHomeDemo(
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Hello, \nusername".uppercase(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.Message, contentDescription = "chat")
            }
        }
    )
}
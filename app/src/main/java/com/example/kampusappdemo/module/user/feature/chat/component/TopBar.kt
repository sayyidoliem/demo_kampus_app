package com.example.kampusappdemo.module.user.feature.chat.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarChatDemo(
    navigate: () -> Unit,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Chat") },
        navigationIcon = {
            IconButton(onClick = { navigate() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            }
        }
    )
}

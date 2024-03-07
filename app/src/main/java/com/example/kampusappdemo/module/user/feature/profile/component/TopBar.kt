package com.example.kampusappdemo.module.user.feature.profile.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarProfileDemo(
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Profile") },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "")
            }
        },
    )
}
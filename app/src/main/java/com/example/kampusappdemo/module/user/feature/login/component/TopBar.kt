package com.example.kampusappdemo.module.user.feature.login.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLoginDemo(navigate: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navigate() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, contentDescription = ""
                )
            }
        },
        title = { /*TODO*/ },
    )
}
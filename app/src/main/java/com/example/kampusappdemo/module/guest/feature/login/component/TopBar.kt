package com.example.kampusappdemo.module.guest.feature.login.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.data.kotpref.SettingPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLoginDemo(navigate: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navigate() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = ""
                )
            }
        },
        title = { /*TODO*/ },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSignInLoginDemo(navigate: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            if (SettingPreferences.typeUser == SettingPreferences.GUEST) {
                IconButton(onClick = { navigate() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = ""
                    )
                }
            }
        },
        title = { /*TODO*/ },
    )
}
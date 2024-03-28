package com.example.kampusappdemo.module.guest.feature.needlogin.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NeedLoginScreens(navigateUp: () -> Unit, navigateToSigIn: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This feature must log in")
        TextButton(onClick = { navigateToSigIn() }) {
            Text(text = "Sign In now")
        }
    }
}
//
//@Composable
//fun NeedLoginScreens(navigateUp: () -> Unit, navigateToSigIn: () -> Unit) {

//}
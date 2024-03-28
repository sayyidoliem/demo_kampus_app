package com.example.kampusappdemo.module.user.feature.home.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.module.user.feature.home.viewmodel.HomeViewModel

@Composable
fun SignInHomeDialog(navigate : () -> Unit, viewModel: HomeViewModel){
    AlertDialog(
        icon = {
            Icon(imageVector = Icons.Default.Warning, contentDescription = "")
        },
        title = {
            Text(text = "Need Sign In")
        },
        text = {
            Text(text = "Please sign in to use the other feature from SCOLA : A Privilege")
        },
        onDismissRequest = { viewModel.hideDialog() },
        confirmButton = {
            Button(onClick = { navigate()}) {
                Text(text = "Sign In")
            }
        },
        dismissButton = {
            TextButton(onClick = { viewModel.hideDialog() }) {
                Text(text = "Dissmiss")
            }
        }
    )
}
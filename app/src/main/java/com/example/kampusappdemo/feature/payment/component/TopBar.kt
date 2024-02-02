package com.example.kampusappdemo.feature.payment.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPaymentDemo(
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Payment") },
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
    )
}

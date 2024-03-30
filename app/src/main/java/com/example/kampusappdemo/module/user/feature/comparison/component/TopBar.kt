package com.example.kampusappdemo.module.user.feature.comparison.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.module.user.feature.comparison.viewmodel.ComparisonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComparisonScreensDemo(navigate : () -> Unit, viewModel : ComparisonViewModel) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Comparison") },
        navigationIcon = {
            IconButton(
                onClick = { navigate() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        actions = {
            TextButton(
                colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error),
                onClick = { viewModel.showDeleteDialog() }) {
                Text(text = "Reset")
            }
        }
    )
}
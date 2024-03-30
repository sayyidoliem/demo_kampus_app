package com.example.kampusappdemo.module.user.feature.comparison.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.module.user.feature.comparison.viewmodel.ComparisonViewModel

@Composable
fun FABComparisonScreensDemo(viewModel : ComparisonViewModel) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { viewModel.showAddDialog() }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "")
    }
}
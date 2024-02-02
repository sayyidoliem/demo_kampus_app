package com.example.kampusappdemo.feature.bookmark.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSavedDemo() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Saved") },
    )
}
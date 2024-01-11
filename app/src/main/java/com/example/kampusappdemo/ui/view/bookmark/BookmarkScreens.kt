package com.example.kampusappdemo.ui.view.bookmark

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kampusappdemo.ui.component.TopAppBarSavedDemo

@Composable
fun BookmarkScreens(modifier: Modifier, viewModel: BookmarkViewModel) {
    Scaffold(
        topBar = {
            TopAppBarSavedDemo()
        }
    ) {
        it
    }
}
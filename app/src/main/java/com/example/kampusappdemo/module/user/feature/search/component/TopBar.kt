package com.example.kampusappdemo.module.user.feature.search.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearchDemo(
    searchIconState: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Name Product") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { searchIconState() }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            }
        }
    )
}
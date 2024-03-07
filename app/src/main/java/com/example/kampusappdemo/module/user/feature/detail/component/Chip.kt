package com.example.kampusappdemo.module.user.feature.detail.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipDetailDemo(
    label: String,
    modifier: Modifier
) {
    val selected by remember { mutableStateOf(true) }

    ElevatedFilterChip(
        modifier = modifier,
        onClick = { },
        label = {
            Text(label)
        },
        selected = selected,
    )
}

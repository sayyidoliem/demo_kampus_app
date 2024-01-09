package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemSettingsDemo(
    icon: ImageVector,
    headLineText: String,
    state: Boolean
) {
    ListItem(
        leadingContent = { Image(imageVector = icon, contentDescription = "") },
        headlineContent = { Text(text = headLineText) },
        trailingContent = {
            Switch(checked = state != state, onCheckedChange = { state  })
        }
    )
}
package com.example.kampusappdemo.module.guest.feature.profile.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ListItemIndentitySettingDemo(
    headLineText: String,
    supportText: String,
) {
    Column {
        ListItem(
            headlineContent = { Text(text = headLineText) },
            supportingContent = { Text(text = supportText) },
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ListItemOtherProfileDemo(
    headLineText: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Column {
        ListItem(
            modifier = Modifier.clickable { onClick() },
            leadingContent = {
                IconButton(onClick = {  }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
            },
            headlineContent = { Text(text = headLineText) },
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}
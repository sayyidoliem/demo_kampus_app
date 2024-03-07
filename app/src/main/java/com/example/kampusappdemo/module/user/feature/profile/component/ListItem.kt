package com.example.kampusappdemo.module.user.feature.profile.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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

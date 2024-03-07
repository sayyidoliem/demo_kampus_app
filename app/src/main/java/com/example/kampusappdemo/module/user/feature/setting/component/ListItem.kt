package com.example.kampusappdemo.module.user.feature.setting.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ListItemDocumentSettingDemo(
    headLineText: String,
    supportText: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Column {
        ListItem(
            headlineContent = { Text(text = headLineText) },
            supportingContent = { Text(text = supportText) },
            trailingContent = {
                IconButton(onClick = { onClick() }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
            }
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ListItemDropdownDemo(
    icon: ImageVector,
    headLineText: String,
    supportText: String,
    onClick: () -> Unit,
) {
    Column {
        ListItem(
            leadingContent = { Icon(imageVector = icon, contentDescription = "") },
            headlineContent = { Text(text = headLineText) },
            supportingContent = { Text(text = supportText) },
            trailingContent = {
                IconButton(onClick = { onClick() }) {
                    Icon(imageVector = Icons.Default.OpenInNew, contentDescription = "")
                }
            }
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ListItemSwitchSettingsDemo(
    icon: ImageVector,
    headLineText: String,
    supportText: String,
    isSwitchClicked: Boolean,
    onSwitchClick: (Boolean) -> Unit,
) {
    Column {
        ListItem(
            leadingContent = { Icon(imageVector = icon, contentDescription = "") },
            headlineContent = { Text(text = headLineText) },
            supportingContent = { Text(text = supportText) },
            trailingContent = {
                Switch(checked = isSwitchClicked,
                    onCheckedChange = { onSwitchClick(it) })
            }
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}


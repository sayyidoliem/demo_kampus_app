package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
fun ListItemDocumentSettingDemo(
    headLineText: String,
    supportText: String,
    icon: ImageVector
) {
    Column {
        ListItem(
            headlineContent = { Text(text = headLineText) },
            supportingContent = { Text(text = supportText) },
            trailingContent = {
                IconButton(onClick = { }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
            }
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ListItemBookingDemo(
    image: Int,
    headLineText: String,
    supportText: String,
    onClick: () -> Unit
) {
    Column {
        ListItem(
            leadingContent = {
                Image(
                    modifier = Modifier.size(56.dp),
                    painter = painterResource(id = image),
                    contentDescription = ""
                )
            },
            headlineContent = { Text(text = headLineText) },
            supportingContent = { Text(text = supportText) },
            trailingContent = {
                Button(onClick = { onClick() }) {
                    Text(text = "Pay Now")
                }
            }
        )
        Divider(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ListItemPaymentDetailDemo(
    title: String,
    subTitle: String
){
    Column {
        ListItem(
            overlineContent = {
                Text(text = subTitle)
            },
            headlineContent = {
                Text(text = title)
            },
            trailingContent = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Edit")
                }
            }
        )
        Divider()
    }
}
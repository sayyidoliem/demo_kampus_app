package com.example.kampusappdemo.module.admin.feature.chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R

@Composable
fun ListItemChatAdminDemo(navigate : () -> Unit){
    ListItem(
        modifier = Modifier.clickable { navigate()},
        leadingContent = {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(56.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
            )
        },
        headlineContent = { Text(text = "User") },
        supportingContent = { Text(text = "Another chat...") },
        trailingContent = { Text(text = "10.10") },
        tonalElevation = 2.dp
    )
}
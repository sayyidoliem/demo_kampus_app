package com.example.kampusappdemo.feature.booking.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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

package com.example.kampusappdemo.feature.payment.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

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
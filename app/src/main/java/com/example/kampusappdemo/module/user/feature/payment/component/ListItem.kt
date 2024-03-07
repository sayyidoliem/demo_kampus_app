package com.example.kampusappdemo.module.user.feature.payment.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListItemPaymentDetailDemo(
    title: String,
    subTitle: String,
    trailingTitle: String
) {
    Column {
        ListItem(
            overlineContent = {
                Text(text = subTitle)
            },
            headlineContent = {
                Text(text = title)
            },
            trailingContent = {
                if (trailingTitle.isNotEmpty()){
                    Text(text = trailingTitle)
                } else{
                    Text(text = "-")
                }
            }
        )
        Divider()
    }
}

@Composable
fun ListItemPaymentDetailDescriptionDemo(
    title: String,
    subTitle: String
) {
    Column {
        ListItem(
            overlineContent = {
                Text(text = subTitle)
            },
            headlineContent = {
                Text(text = title)
            },
        )
    }
}
package com.example.kampusappdemo.module.guest.feature.profile.component

import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProfileDemo() {
    Card {
        ListItem(
            headlineContent = {
                Text(text = "Name")
            },
            supportingContent = {
                Text(text = "Aksa Akakaak")
            }
        )
        Divider()
        ListItem(
            headlineContent = {
                Text(text = "Phone Number")
            },
            supportingContent = {
                Text(text = "+123 - 4567 - 8910")
            }
        )
        Divider()
        ListItem(
            headlineContent = {
                Text(text = "E - Mail")
            },
            supportingContent = {
                Text(text = "Blablabla@gmail.com")
            }
        )
    }
}

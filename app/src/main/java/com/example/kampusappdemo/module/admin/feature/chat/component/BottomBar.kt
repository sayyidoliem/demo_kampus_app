package com.example.kampusappdemo.module.admin.feature.chat.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.ui.component.ChatInputDemo

@Composable
fun BottomAppBarChatAdminDemo() {
    var searchBar by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        ChatInputDemo(
            modifier = Modifier.weight(0.8F),
            p = "Let's Chat",
            i = searchBar,
            isShowSearchBar = { !searchBar })
        Spacer(modifier = Modifier.padding(4.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            shape = CircleShape
        ) {
            IconButton(
                modifier = Modifier.padding(5.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "")
            }
        }
    }
}
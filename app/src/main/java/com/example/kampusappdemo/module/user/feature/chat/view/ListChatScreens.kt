package com.example.kampusappdemo.module.user.feature.chat.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.admin.feature.chat.component.TopAppBarListChatAdminDemo
import com.example.kampusappdemo.module.user.feature.chat.component.ListItemChatUserDemo
import com.example.kampusappdemo.module.user.feature.chat.component.TopAppBarListChatUserDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListChatUserScreens(navigate: () -> Unit, navigateUp: () -> Unit) {
    Scaffold(
        topBar = { TopAppBarListChatUserDemo(navigate = { navigateUp() }) }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    query = "",
                    onQueryChange = {},
                    onSearch = {},
                    active = false,
                    onActiveChange = {},
                    placeholder = { Text(text = "Search") },
                    leadingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.FilterAlt, contentDescription = "")
                        }
                    }
                ) {

                }
                Spacer(modifier = Modifier.padding(16.dp))
            }
            items(11) {
                ListItemChatUserDemo(navigate = { navigate() })
                Divider()
            }
        }
    }
}
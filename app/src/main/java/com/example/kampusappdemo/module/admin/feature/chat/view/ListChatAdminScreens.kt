package com.example.kampusappdemo.module.admin.feature.chat.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.admin.feature.chat.component.ListItemChatAdminDemo
import com.example.kampusappdemo.module.admin.feature.chat.component.TopAppBarListChatAdminDemo
import com.example.kampusappdemo.module.guest.feature.profile.component.ListItemOtherProfileDemo
import com.example.kampusappdemo.module.guest.feature.setting.component.ListItemDocumentProfileDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListChatAdminScreens(navigate: () -> Unit) {
    SettingPreferences.typeUser = SettingPreferences.ADMIN

    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = listOf("Main", "General")
    Scaffold(
        topBar = { TopAppBarListChatAdminDemo() }
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
            item {
                TabRow(
                    selectedTabIndex = selectedIndex,
                    containerColor = MaterialTheme.colorScheme.surface,
                ) {
                    list.forEachIndexed { index, text ->
                        val selected = selectedIndex == index
                        Tab(
                            selected = selected,
                            onClick = { selectedIndex = index },
                            text = {
                                Text(
                                    text = text,
                                    color =
                                    if (selected) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            })
                    }
                }

            }
            when (selectedIndex) {
                0 -> {
                    items(4) {
                        ListItemChatAdminDemo(navigate = { navigate() })
                        Divider()
                    }
                }

                1 -> {
                    items(8) {
                        ListItemChatAdminDemo(navigate = { navigate() })
                        Divider()
                    }

                }
            }

        }
    }
}
package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.model.EducationData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DockedSearchBarDemo(
    text: String,
    active: Boolean,
    list : @Composable () -> Unit
) {
    var textSearchBar by rememberSaveable { mutableStateOf(text) }
    var activeSearchBar by rememberSaveable { mutableStateOf(active) }

    DockedSearchBar(
        query = textSearchBar,
        onQueryChange = { textSearchBar = it },
        onSearch = { !activeSearchBar },
        active = activeSearchBar,
        placeholder = { Text(text = "Search ") },
        onActiveChange = { activeSearchBar = it },
        trailingIcon = {
            if (activeSearchBar) {
                IconButton(onClick = {
                    if (textSearchBar.isNotEmpty()) textSearchBar =
                        "" else activeSearchBar = false
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
        },
        leadingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        list()
    }
}
package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DockedSearchBarDemo(
    p: String,
    i: Boolean,
    isShowSearchBar: () -> Unit
) {
    var textSearchBar by rememberSaveable { mutableStateOf("") }
    var searchBar by rememberSaveable { mutableStateOf(false) }

    DockedSearchBar(
        query = textSearchBar,
        onQueryChange = { textSearchBar = it },
        onSearch = { query ->
        },
        active = searchBar,
        placeholder = { Text(text = "Search ") },
        onActiveChange = { searchBar = it },
        trailingIcon = {
            if (searchBar) {
                IconButton(onClick = {
                    if (textSearchBar.isNotEmpty()) textSearchBar =
                        "" else searchBar = false
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
    ) {}
}
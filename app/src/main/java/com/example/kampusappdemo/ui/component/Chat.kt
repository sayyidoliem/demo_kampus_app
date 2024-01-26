package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatInputDemo(
    modifier: Modifier,
    p: String,
    i: Boolean,
    isShowSearchBar: () -> Unit
) {
    var textSearchBar by rememberSaveable { mutableStateOf("") }
    var searchBar by rememberSaveable { mutableStateOf(false) }
    DockedSearchBar(
        modifier = modifier,
        query = textSearchBar,
        onQueryChange = { textSearchBar = it },
        onSearch = { query ->
        },
        active = false,
        placeholder = { Text(text = "Type a message") },
        onActiveChange = { searchBar = it },
        trailingIcon = {
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.AttachFile, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "")
                }
            }
        },
    ) {}
}
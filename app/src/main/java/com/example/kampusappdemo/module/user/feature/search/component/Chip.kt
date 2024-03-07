package com.example.kampusappdemo.module.user.feature.search.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.ui.component.TextHeadlineDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipSearchDemo(
    label: String,
    modifier: Modifier
) {
    var selected by remember { mutableStateOf(false) }

    ElevatedFilterChip(
        modifier = modifier,
        onClick = { selected = !selected },
        label = {
            Text(label)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipSearchDemo(
    label: String,
    modifier: Modifier,
    icon: ImageVector,
    onClick: () -> Unit
) {
    ElevatedSuggestionChip(
        modifier = modifier,
        onClick = { onClick() },
        enabled = true,
        label = {
            Text(label)
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = "Done icon",
                modifier = Modifier.size(FilterChipDefaults.IconSize)
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterList(
    title: String,
    list: List<String>,
    modifier: Modifier = Modifier
) {
    val selectedItem = remember { mutableStateOf(listOf<String>()) }

    TextHeadlineDemo(modifier = modifier.padding(start = 16.dp, top = 16.dp), text = title)
    val filterItems = list.toSet()
    LazyRow(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        item {
            filterItems.forEach { item ->
                ElevatedFilterChip(
                    selected = selectedItem.value.contains(item),
                    leadingIcon = if (selectedItem.value.contains(item)) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                    onClick = {
                        if (selectedItem.value.contains(item)) {
                            selectedItem.value = selectedItem.value - item
                        } else {
                            selectedItem.value = selectedItem.value + item
                        }
                    },
                    label = { Text(text = item) })
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}
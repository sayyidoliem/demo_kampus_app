package com.example.kampusappdemo.ui.view.search

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.LastSeenPreferences
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.model.EducationData
import com.example.kampusappdemo.ui.component.AssistChipSearchDemo
import com.example.kampusappdemo.ui.component.CardListHomeDemo
import com.example.kampusappdemo.ui.component.CardListSearchDemo
import com.example.kampusappdemo.ui.component.DockedSearchBarDemo
import com.example.kampusappdemo.ui.component.FilterChipSearchDemo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreens(
    modifier: Modifier,
    navigate: (name: String?, type: String?, rating: Float?, city: String?, image: String?, desc: String?) -> Unit,
    viewModel: SearchViewModel
) {
    val context = LocalContext.current

    val list = viewModel.dataList(context)

    val isSearching by viewModel.isSearching.collectAsState()

    var text by rememberSaveable { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    // Create state variabel for save data
    val data = remember { mutableStateOf(listOf<EducationData>()) }

    val filteredData = remember { mutableStateOf(listOf<EducationData>()) }

    // Launcheffect for calling data at first composable build
    LaunchedEffect(Unit) {
        scope.launch {
            data.value = viewModel.dataList(context)
            filteredData.value = viewModel.filterDataBySearch(data.value, text)
        }
    }

    LaunchedEffect(text) {
        scope.launch {
            filteredData.value = viewModel.filterDataBySearch(data.value, text)
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            DockedSearchBar(
                query = text,//searchText,//text showed on SearchBar
                onQueryChange = {
                    text = it
                },//viewModel::onSearchTextChange, //update the value of searchText
                onSearch = { viewModel.onToogleSearch() }, //the callback to be invoked when the input service triggers the ImeAction.Search action
                active = isSearching, //whether the user is searching or not
                onActiveChange = { viewModel.onToogleSearch() }, //the callback to be invoked when this search bar's active state is changed
                placeholder = { Text(text = "Search ") },
                trailingIcon = {
                    if (isSearching) {
                        IconButton(onClick = {
                            if (text.isNotEmpty()) text = "" else viewModel.onToogleSearch()
                        }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    }
                },
                leadingIcon = {
                    IconButton(onClick = { viewModel.onToogleSearch() }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    when {
                        text.isEmpty() -> {
                            itemsIndexed(list) { index, educationData ->
                                LastSeenPreferences.apply {
                                    this.index = index
                                    instance = educationData.instance
                                    name = educationData.name
                                    image = educationData.image
                                    rating = educationData.rating.toFloat()
                                    city = educationData.location.city
                                    province = educationData.location.province
                                }
                                val resultText = educationData.name
                                ListItem(
                                    modifier = Modifier.clickable {
                                        text = resultText
                                        viewModel.onToogleSearch()
                                    },
                                    overlineContent = { Text(text = educationData.instance) },
                                    headlineContent = { Text(text = resultText) },
                                    supportingContent = { Text(text = "${educationData.location.city}, ${educationData.location.province}") }
                                )
                            }
                        }
                        else -> {
                            itemsIndexed(filteredData.value) { index, educationData ->
                                LastSeenPreferences.apply {
                                    this.index = index
                                    instance = educationData.instance
                                    name = educationData.name
                                    image = educationData.image
                                    rating = educationData.rating.toFloat()
                                    city = educationData.location.city
                                    province = educationData.location.province
                                }
                                val resultText = educationData.name
                                ListItem(
                                    modifier = Modifier.clickable {
                                        text = resultText
                                        viewModel.onToogleSearch()
                                    },
                                    overlineContent = { Text(text = educationData.instance) },
                                    headlineContent = { Text(text = resultText) },
                                    supportingContent = { Text(text = "${educationData.location.city}, ${educationData.location.province}") }
                                )
                            }
                        }
                    }
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyRow(
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                item {
                    AssistChipSearchDemo(
                        label = "Filter",
                        modifier = Modifier.padding(8.dp),
                        icon = Icons.Default.Tune,
                        onClick = { }
                    )
                }
                items(1) {
                    FilterChipSearchDemo(
                        modifier = Modifier.padding(8.dp),
                        label = "Jalur Pendaftaran"
                    )
                    FilterChipSearchDemo(modifier = Modifier.padding(8.dp), label = "Lokasi")
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                if (text.isEmpty()) {
                    items(list) { educationData ->
                        ListItem(headlineContent = { Text(text = educationData.name) })
                        CardListSearchDemo(
                            nameCampus = educationData.name,
                            typeCampus = educationData.instance,
                            ratingCampus = educationData.rating,
                            image = educationData.image,
                            location = educationData.location.city,
                            onClick = {
                                navigate(
                                    educationData.name,
                                    educationData.instance,
                                    educationData.rating.toFloat(),
                                    educationData.location.city,
                                    educationData.image,
                                    educationData.description.toString(),
                                )
                            },
                        )
                    }
                } else {
                    items(filteredData.value) { educationData ->
                        ListItem(headlineContent = { Text(text = educationData.name) })
                        CardListSearchDemo(
                            nameCampus = educationData.name,
                            typeCampus = educationData.instance,
                            ratingCampus = educationData.rating,
                            image = educationData.image,
                            location = educationData.location.city,
                            onClick = {
                                navigate(
                                    educationData.name,
                                    educationData.instance,
                                    educationData.rating.toFloat(),
                                    educationData.location.city,
                                    educationData.image,
                                    educationData.description.toString(),
                                )
                            },
                        )
                    }
                }

            }
        }
    }
//    when {
//        viewModel.searchBar.value -> {
//            DockedSearchBarDemo(
//                text = searchText,
//                active = isSearching,
//                list = {
//                    LazyColumn(
//                        modifier = Modifier.fillMaxWidth(),
//                        contentPadding = PaddingValues(16.dp),
//                        verticalArrangement = Arrangement.spacedBy(4.dp)
//                    ) {
//                        items(2) { idx ->
//                            val resultText = "Suggestion $idx"
//                            ListItem(
//                                modifier = Modifier.clickable {
////                                viewModel.searchText.value = resultText
////                                isSearching = false
//                                },
//                                headlineContent = {
//                                    Text(
//                                        text = resultText,
//                                        style = MaterialTheme.typography.titleMedium
//                                    )
//                                },
//                                supportingContent = {
//                                    Text(
//                                        text = "Additional info",
//                                        style = MaterialTheme.typography.titleMedium
//                                    )
//                                },
//                                leadingContent = {
//                                    Icon(
//                                        Icons.Rounded.Star,
//                                        contentDescription = null
//                                    )
//                                },
//                            )
//                        }
//                    }
//                }
//            )
//        }
//    }
}
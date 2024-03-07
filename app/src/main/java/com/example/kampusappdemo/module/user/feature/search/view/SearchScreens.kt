package com.example.kampusappdemo.module.user.feature.search.view

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.LastSeenPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.model.EducationData
import com.example.kampusappdemo.module.user.feature.search.component.AssistChipSearchDemo
import com.example.kampusappdemo.module.user.feature.search.component.CardListSearchDemo
import com.example.kampusappdemo.module.user.feature.search.component.FilterBottomSheetSearchDemo
import com.example.kampusappdemo.module.user.feature.search.component.FilterChipSearchDemo
import com.example.kampusappdemo.module.user.feature.search.viewmodel.SearchViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreens(
    modifier: Modifier,
    navigate: (index: Int?) -> Unit,
    viewModel: SearchViewModel
) {
    val context = LocalContext.current

    val list = viewModel.dataList(context)

    val isSearching by viewModel.isSearching.collectAsState()

    val scope = rememberCoroutineScope()

    // Create state variabel for save data
    val data = remember { mutableStateOf(listOf<EducationData>()) }

    val filteredData = remember { mutableStateOf(listOf<EducationData>()) }

    // Launcheffect for calling data at first composable build
    LaunchedEffect(Unit) {
        scope.launch {
            data.value = viewModel.dataList(context)
            filteredData.value = viewModel.filterDataBySearch(data.value, viewModel.textQuery)
        }
    }

    LaunchedEffect(viewModel.textQuery) {
        scope.launch {
            filteredData.value = viewModel.filterDataBySearch(data.value, viewModel.textQuery)
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            DockedSearchBar(
                query = viewModel.textQuery,
                onQueryChange = {
                    viewModel.updateTextQuery(it)
                },
                onSearch = { viewModel.onToogleSearch() },
                active = isSearching,
                onActiveChange = { viewModel.onToogleSearch() },
                placeholder = { Text(text = "Search ") },
                trailingIcon = {
                    if (isSearching) {
                        IconButton(onClick = {
                            when {
                                viewModel.textQuery.isNotEmpty() -> viewModel.updateTextQuery("")
                                else -> viewModel.onToogleSearch()
                            }
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
                        viewModel.textQuery.isEmpty() -> {
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
                                val blabla = educationData.studyProgram
                                ListItem(
                                    modifier = Modifier.clickable {
                                        viewModel.updateTextQuery("$resultText$blabla")
//                                        searchTextQuery = "$resultText$blabla"
                                        viewModel.onToogleSearch()
                                    },
                                    overlineContent = {
                                        if (educationData.studyProgram.isEmpty()) {
                                            Text(text = educationData.instance)
                                        } else {
                                            Text(text = "${educationData.instance} | ${educationData.studyProgram}")
                                        }
                                    },
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
                                val blabla = educationData.studyProgram
                                ListItem(
                                    modifier = Modifier.clickable {
                                        viewModel.updateTextQuery("$resultText$blabla")
//                                        searchTextQuery = "$resultText $blabla"
                                        viewModel.onToogleSearch()
                                    },
                                    overlineContent = {
                                        if (educationData.studyProgram.isEmpty()) {
                                            Text(text = educationData.instance)
                                        } else {
                                            Text(text = "${educationData.instance} | ${educationData.studyProgram}")
                                        }
                                    },
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
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            LazyRow(
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                item {
                    AssistChipSearchDemo(
                        label = "Filter",
                        modifier = Modifier.padding(8.dp),
                        icon = Icons.Default.Tune,
                        onClick = { viewModel.onToogleFilter() }
                    )
                }
                items(1) {
                    FilterChipSearchDemo(
                        modifier = Modifier.padding(8.dp),
                        label = "Rating Tertinggi"
                    )
                    FilterChipSearchDemo(modifier = Modifier.padding(8.dp), label = "Umum")
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                if (viewModel.textQuery.isEmpty()) {
                    items(list) { educationData ->
                        ListItem(headlineContent = { Text(text = educationData.name) })
                        CardListSearchDemo(
                            nameCampus = educationData.name,
                            studyProgram = educationData.studyProgram,
                            typeCampus = educationData.instance,
                            ratingCampus = educationData.rating,
                            image = ImageDummy[educationData.id].image,
                            city = educationData.location.city,
                            province = educationData.location.province,
                            onClick = {
                                navigate(educationData.id)
                            },
                        )
                    }
                } else {
                    items(filteredData.value) { educationData ->
                        ListItem(headlineContent = { Text(text = educationData.name) })
                        CardListSearchDemo(
                            nameCampus = educationData.name,
                            studyProgram = educationData.studyProgram,
                            typeCampus = educationData.instance,
                            ratingCampus = educationData.rating,
                            image = ImageDummy[educationData.id].image,
                            city = educationData.location.city,
                            province = educationData.location.province,
                            onClick = {
                                navigate(educationData.id)
                            },
                        )
                    }
                }

            }
        }
    }
    if (viewModel.isFilter) {
        FilterBottomSheetSearchDemo(
            list = list,
            viewModel = viewModel
        )
    }
}
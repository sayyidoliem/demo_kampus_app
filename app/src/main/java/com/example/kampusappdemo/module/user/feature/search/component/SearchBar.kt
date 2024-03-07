//package com.example.kampusappdemo.feature.search.component
//
//import android.content.Context
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.DockedSearchBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.ListItem
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import com.example.kampusappdemo.data.kotpref.LastSeenPreferences
//import com.example.kampusappdemo.feature.search.viewmodel.SearchViewModel
//import com.example.kampusappdemo.model.EducationData
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DockedSearchBarSearchDemo(searchTextQuery: String, viewModel: SearchViewModel, context : Context) {
//
//    var text by rememberSaveable { mutableStateOf(searchTextQuery) }
////    var text = searchTextQuery
//
//    val isSearching by viewModel.isSearching.collectAsState()
//
//    val scope = rememberCoroutineScope()
//
//    val list = viewModel.dataList(context)
//
//    val filteredData = remember { mutableStateOf(listOf<EducationData>()) }
//
//    val data = remember { mutableStateOf(listOf<EducationData>()) }
//
//    // Launcheffect for calling data at first composable build
//    LaunchedEffect(Unit) {
//        scope.launch {
//            data.value = viewModel.dataList(context)
//            filteredData.value = viewModel.filterDataBySearch(data.value, searchTextQuery)
//        }
//    }
//
//    LaunchedEffect(searchTextQuery) {
//        scope.launch {
//            filteredData.value = viewModel.filterDataBySearch(data.value, searchTextQuery)
//        }
//    }
//
//    DockedSearchBar(
//        query = text,
//        onQueryChange = {
//            text = it
//        },
//        onSearch = { viewModel.onToogleSearch() },
//        active = isSearching,
//        onActiveChange = { viewModel.onToogleSearch() },
//        trailingIcon = {
//            if (isSearching) {
//                IconButton(onClick = {
//                    if (searchTextQuery.isNotEmpty()) text =
//                        "" else viewModel.onToogleSearch()
//                }) {
//                    Icon(
//                        imageVector = Icons.Default.Close,
//                        contentDescription = null
//                    )
//                }
//            }
//        },
//        leadingIcon = {
//            IconButton(onClick = { viewModel.onToogleSearch() }) {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = null
//                )
//            }
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        LazyColumn(
//            contentPadding = PaddingValues(16.dp),
//            verticalArrangement = Arrangement.spacedBy(4.dp)
//        ) {
//            when {
//                searchTextQuery.isEmpty() -> {
//                    itemsIndexed(list) { index, educationData ->
//                        LastSeenPreferences.apply {
//                            this.index = index
//                            instance = educationData.instance
//                            name = educationData.name
//                            image = educationData.image
//                            rating = educationData.rating.toFloat()
//                            city = educationData.location.city
//                            province = educationData.location.province
//                        }
//                        val resultText = educationData.name
//                        val blabla = educationData.studyProgram
//                        ListItem(
//                            modifier = Modifier.clickable {
//                                text = "$resultText$blabla"
//                                viewModel.onToogleSearch()
//                            },
//                            overlineContent = {
//                                if (educationData.studyProgram.isEmpty()) {
//                                    Text(text = educationData.instance)
//                                } else {
//                                    Text(text = "${educationData.instance} | ${educationData.studyProgram}")
//                                }
//                            },
//                            headlineContent = { Text(text = resultText) },
//                            supportingContent = { Text(text = "${educationData.location.city}, ${educationData.location.province}") }
//                        )
//                    }
//                }
//
//                else -> {
//                    itemsIndexed(filteredData.value) { index, educationData ->
//                        LastSeenPreferences.apply {
//                            this.index = index
//                            instance = educationData.instance
//                            name = educationData.name
//                            image = educationData.image
//                            rating = educationData.rating.toFloat()
//                            city = educationData.location.city
//                            province = educationData.location.province
//                        }
//                        val resultText = educationData.name
//                        val blabla = educationData.studyProgram
//                        ListItem(
//                            modifier = Modifier.clickable {
//                                text = "$resultText $blabla"
//                                viewModel.onToogleSearch()
//                            },
//                            overlineContent = {
//                                if (educationData.studyProgram.isEmpty()) {
//                                    Text(text = educationData.instance)
//                                } else {
//                                    Text(text = "${educationData.instance} | ${educationData.studyProgram}")
//                                }
//                            },
//                            headlineContent = { Text(text = resultText) },
//                            supportingContent = { Text(text = "${educationData.location.city}, ${educationData.location.province}") }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
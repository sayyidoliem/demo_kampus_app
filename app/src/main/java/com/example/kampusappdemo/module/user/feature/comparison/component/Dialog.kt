package com.example.kampusappdemo.module.user.feature.comparison.component

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.data.local.datastore.BookmarkData
import com.example.kampusappdemo.data.local.datastore.UserData
import com.example.kampusappdemo.model.EducationData
import com.example.kampusappdemo.module.guest.feature.profile.component.ConfirmationChangeDialog
import com.example.kampusappdemo.module.guest.feature.profile.component.TextFieldEditProfileDemo
import com.example.kampusappdemo.module.guest.feature.profile.viewmodel.ProfileViewModel
import com.example.kampusappdemo.module.user.feature.comparison.viewmodel.ComparisonViewModel
import com.example.kampusappdemo.module.user.feature.search.component.AssistChipSearchDemo
import com.example.kampusappdemo.module.user.feature.search.component.CardListSearchDemo
import com.example.kampusappdemo.module.user.feature.search.component.FilterChipSearchDemo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddComparisonDialogDemo(
    context : Context,
    viewModel: ComparisonViewModel
) {
    val list = viewModel.dataList(context)

    val dataBookmarkStore = BookmarkData(context)

    val isSearching by viewModel.isSearching.collectAsState()

    val scope = rememberCoroutineScope()

    // Create state variabel for save data
    val data = remember { mutableStateOf(listOf<EducationData>()) }

    val filteredData = remember { mutableStateOf(listOf<EducationData>()) }

    // Launch-effect for calling data at first composable build
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

    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = {
            viewModel.hideAddDialog()
        }
    ) {
        Scaffold(
            topBar = {
                DockedSearchBar(
                    query = viewModel.textQuery,
                    onQueryChange = {
                        viewModel.updateTextQuery(it)
                    },
                    onSearch = { viewModel.onToggleSearch() },
                    active = isSearching,
                    onActiveChange = { viewModel.onToggleSearch() },
                    placeholder = { Text(text = "Search ") },
                    trailingIcon = {
                        if (isSearching) {
                            IconButton(onClick = {
                                when {
                                    viewModel.textQuery.isNotEmpty() -> viewModel.updateTextQuery("")
                                    else -> viewModel.onToggleSearch()
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
                        IconButton(onClick = { viewModel.onToggleSearch() }) {
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
                                    val resultText = educationData.name
                                    val blabla = educationData.studyProgram
                                    ListItem(
                                        modifier = Modifier.clickable {
                                            viewModel.updateTextQuery("$resultText$blabla")
//                                        searchTextQuery = "$resultText$blabla"
                                            viewModel.onToggleSearch()
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
                                    val resultText = educationData.name
                                    val blabla = educationData.studyProgram
                                    ListItem(
                                        modifier = Modifier.clickable {
                                            viewModel.updateTextQuery("$resultText$blabla")
//                                        searchTextQuery = "$resultText $blabla"
                                            viewModel.onToggleSearch()
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
            },
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
            ) {
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
                                    viewModel.addComparison(educationData.id)
                                    viewModel.hideAddDialog()
                                },
                                onFavorite = {
                                    scope.launch {
                                        dataBookmarkStore.saveIndex(educationData.id)
                                    }
                                }
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
                                    viewModel.addComparison(educationData.id)
                                    viewModel.hideAddDialog()
                                },
                                onFavorite = {}
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun DeleteComparisonDialogDemo(viewModel: ComparisonViewModel) {
    AlertDialog(
        icon = {
            Icon(Icons.Default.RemoveCircle, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Reset")
        },
        text = {
            Column {
                Text(text = "Are you really want to reset the comparison?")
            }
        },
        onDismissRequest = {
            viewModel.hideDeleteDialog()
        },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                onClick = {
                    viewModel.deleteComparison()
                    viewModel.hideDeleteDialog()
                }
            ) {
                Text("Delete")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.hideDeleteDialog()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailComparisonDialogDemo(
    name: String,
    textDescription: List<String>,
    textRequirement: List<String>,
    textTermsCondition: List<String>,
    viewModel: ComparisonViewModel
) {
    val scrollState = rememberScrollState()

    Dialog(onDismissRequest = { }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(title = {
                        Text(
                            text = name,
                            fontWeight = FontWeight.Bold
                        )
                    })
                }
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Description",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    textDescription.forEachIndexed { index, description ->
                        val id = index + 1
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            text = "${id}. $description",
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Requirement",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    textRequirement.forEachIndexed { index, requirement ->
                        val id = index + 1
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            text = "${id}. $requirement",
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Terms and Condition",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    textTermsCondition.forEachIndexed { index, termsCondition ->
                        val id = index + 1
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            text = "${id}. $termsCondition",
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            onClick = { viewModel.hideDetailDialog() },
                        ) {
                            Text("Close")
                        }
                    }
                }
            }
        }
    }
}
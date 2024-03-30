package com.example.kampusappdemo.module.user.feature.bookmark.view

import androidx.collection.emptyIntIntMap
import androidx.collection.emptyIntList
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.kampusappdemo.data.local.datastore.BookmarkData
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.user.feature.bookmark.component.CardListBookmarkDemo
import com.example.kampusappdemo.module.user.feature.bookmark.component.TopAppBarSavedDemo
import com.example.kampusappdemo.module.user.feature.bookmark.viewmodel.BookmarkViewModel


@Composable
fun BookmarkScreens(
    modifier: Modifier,
    viewModel: BookmarkViewModel,
    navigate: (index: Int?) -> Unit,
) {
    val context = LocalContext.current

    val dataBookmarkStore = BookmarkData(context)

    val indexValue by dataBookmarkStore.getIndex.collectAsState(initial = 0)

    val listIndexed = viewModel.filterDataByIndex(context, indexValue)

    SettingPreferences.typeUser = SettingPreferences.USER

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarSavedDemo()
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(it),
            columns = GridCells.Fixed(2)
        ) {
            listIndexed.forEach { educationData ->
                items(educationData.id) {
                    CardListBookmarkDemo(
                        nameCampus = educationData.name,
                        studyProgram = educationData.studyProgram,
                        typeCampus = educationData.instance,
                        ratingCampus = educationData.rating,
                        location = educationData.location,
                        image = ImageDummy[educationData.id].image,
                        onClick = {
                            navigate(
                                educationData.id
                            )
                        },
                        onRemove = {}
                    )
                }
            }
            items(listIndexed) { educationData ->
                CardListBookmarkDemo(
                    nameCampus = educationData.name,
                    studyProgram = educationData.studyProgram,
                    typeCampus = educationData.instance,
                    ratingCampus = educationData.rating,
                    location = educationData.location,
                    image = ImageDummy[educationData.id].image,
                    onClick = {
                        navigate(
                            educationData.id
                        )
                    },
                    onRemove = {}
                )
            }
        }
    }
}
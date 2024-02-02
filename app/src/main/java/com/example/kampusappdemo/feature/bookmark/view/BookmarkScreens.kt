package com.example.kampusappdemo.feature.bookmark.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.kampusappdemo.feature.bookmark.viewmodel.BookmarkViewModel
import com.example.kampusappdemo.feature.bookmark.component.CardListBookmarkDemo
import com.example.kampusappdemo.feature.bookmark.component.TopAppBarSavedDemo

@Composable
fun BookmarkScreens(
    modifier: Modifier,
    viewModel: BookmarkViewModel,
    navigate: (index : Int?) -> Unit,
) {
    val context = LocalContext.current
    val list = viewModel.dataList(context)
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
            items(list) { educationData ->
                CardListBookmarkDemo(
                    nameCampus = educationData.name,
                    typeCampus = educationData.instance,
                    ratingCampus = educationData.rating,
                    location = educationData.location,
                    image = educationData.image,
                    onClick = {
                        navigate(
                            educationData.id
                        )
                    },
                )
            }
        }
    }
}
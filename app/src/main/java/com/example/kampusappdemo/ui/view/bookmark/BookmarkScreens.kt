package com.example.kampusappdemo.ui.view.bookmark

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.ui.component.CardListBookmarkDemo
import com.example.kampusappdemo.ui.component.CardListSearchDemo
import com.example.kampusappdemo.ui.component.TopAppBarSavedDemo

@Composable
fun BookmarkScreens(
    modifier: Modifier,
    viewModel: BookmarkViewModel,
    navigate: (name: String?, type: String?, rating: Float?, city: String?, image: Int?, desc: String?) -> Unit,
) {
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
            items(University.values()) { university ->
                CardListBookmarkDemo(
                    nameCampus = university.universityName,
                    typeCampus = university.universityType,
                    ratingCampus = university.universityRating.toString(),
                    image = university.universityImage,
                    location = university.universityLocation,
                    onClick = {
                        navigate(
                            university.universityName,
                            university.universityType,
                            university.universityRating,
                            university.universityLocation,
                            university.universityImage,
                            university.universityDescription,
                        )
                    },
                )
            }
        }
    }
}
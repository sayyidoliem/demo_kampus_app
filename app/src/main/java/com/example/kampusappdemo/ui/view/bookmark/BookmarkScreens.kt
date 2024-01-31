package com.example.kampusappdemo.ui.view.bookmark

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.ui.component.CardListBookmarkDemo
import com.example.kampusappdemo.ui.component.CardListSearchDemo
import com.example.kampusappdemo.ui.component.TopAppBarSavedDemo

@Composable
fun BookmarkScreens(
    modifier: Modifier,
    viewModel: BookmarkViewModel,
    navigate: (name: String?, type: String?, rating: Float?, city: String?, image: String?, desc: String?, email: String?, website: String?, terms: String?) -> Unit,
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
                            educationData.name,
                            educationData.instance,
                            educationData.rating.toFloat(),
                            educationData.location.city,
                            educationData.image,
                            educationData.description.toString(),
                            educationData.emails,
                            educationData.website,
                            educationData.termsCondition.toString()
                        )
                    },
                )
            }
        }
    }
}
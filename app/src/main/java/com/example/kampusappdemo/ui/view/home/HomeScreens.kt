package com.example.kampusappdemo.ui.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.LastSeenPreferences
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.ui.component.CardLastSeenHomeDemo
import com.example.kampusappdemo.ui.component.CardListHomeDemo
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo
import com.example.kampusappdemo.ui.component.TopAppBarHomeDemo

@Composable
fun HomeScreens(
    viewModel: HomeViewModel,
    navigate: (name: String?, type: String?, rating: Float?, city: String?, image: String?, desc: String?, email: String?, website: String?, terms: String?) -> Unit,
    actionTopBar: () -> Unit
) {
    val context = LocalContext.current
    val list = viewModel.dataList(context)
    val listLastSeen = viewModel.filterDataByLastSeen(context)
    Scaffold(
        topBar = {
            TopAppBarHomeDemo(
                onClick = { actionTopBar() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            TextHeadlineDemo(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Last seen with you"
            )
            listLastSeen.forEach { educationData ->
                CardLastSeenHomeDemo(
                    nameCampus = educationData.name,
                    typeCampus = educationData.instance,
                    ratingCampus = educationData.rating,
                    location = educationData.location,
                    image = educationData.image
                ) {
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
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    TextSubHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Let's See Last Trending University"
                    )
                    TextHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Trending University"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                }
            }
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(list) { educationData ->
                    CardListHomeDemo(
                        nameCampus = educationData.name,
                        typeCampus = educationData.instance,
                        studyProgram = educationData.studyProgram,
                        ratingCampus = educationData.rating,
                        location = educationData.location,
                        image = educationData.image
                    ) {
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
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    TextSubHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "All Exlusive For You"
                    )
                    TextHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Recomended University"
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                }
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(list) { educationData ->
                    CardListHomeDemo(
                        nameCampus = educationData.name,
                        typeCampus = educationData.instance,
                        studyProgram = educationData.studyProgram,
                        ratingCampus = educationData.rating,
                        location = educationData.location,
                        image = educationData.image
                    ) {
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
                    }
                }
            }
        }

    }
}
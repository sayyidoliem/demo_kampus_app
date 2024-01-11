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
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.database.University
import com.example.kampusappdemo.ui.component.CardLastSeenHomeDemo
import com.example.kampusappdemo.ui.component.CardListHomeDemo
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo
import com.example.kampusappdemo.ui.component.TopAppBarHomeDemo

@Composable
fun HomeScreens(viewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            TopAppBarHomeDemo()
        }
    ) {
        val dataDummy = University.KAMPUS_1
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
            CardLastSeenHomeDemo(
                nameCampus = dataDummy.universityName,
                location = dataDummy.universityLocation,
                image = dataDummy.universityImage,
                onClick = {},
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextHeadlineDemo(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Trending University"
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                }
            }
            TextSubHeadlineDemo(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Let's See Last Trending University"
            )
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(University.values()) { university ->
                    CardListHomeDemo(
                        nameCampus = university.universityName,
                        location = university.universityLocation,
                        image = university.universityImage,
                        onClick = { }
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {

                }
                TextHeadlineDemo(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Recomended University"
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                }
            }
            TextSubHeadlineDemo(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "All Exlusive For You"
            )
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(University.values()) { university ->
                    CardListHomeDemo(
                        nameCampus = university.universityName,
                        location = university.universityLocation,
                        image = university.universityImage,
                        onClick = { }
                    )
                }
            }
        }

    }
}
package com.example.kampusappdemo.ui.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.ui.component.CardListHomeDemo
import com.example.kampusappdemo.ui.component.CardListSearchDemo
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TopAppBarHomeDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreens(viewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            TopAppBarHomeDemo()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            TextHeadlineDemo(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Last seen with you"
            )
            CardListHomeDemo(product = "sfas", address = "sdas", ppp = "adsias")
            TextHeadlineDemo(modifier = Modifier.padding(horizontal = 16.dp), text = "Trending School")
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(23) {
                    CardListHomeDemo(product = "sfas", address = "sdas", ppp = "adsias")
                }
            }
        }

    }
}
//package com.example.kampusappdemo.ui.view.list
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Tune
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.kampusappdemo.data.database.University
//import com.example.kampusappdemo.ui.component.AssistChipSearchDemo
//import com.example.kampusappdemo.ui.component.CardListSearchDemo
//import com.example.kampusappdemo.ui.component.DockedSearchBarDemo
//import com.example.kampusappdemo.ui.component.FilterChipSearchDemo
//import com.example.kampusappdemo.ui.component.TopAppBarListDemo
//import com.example.kampusappdemo.ui.view.search.SearchViewModel
//
//@Composable
//fun ListScreens(
//    modifier: Modifier,
//    title: String,
//    nameUniversity: String,
//    nameCity : String,
//    imageUniversity: Int,
//    nameDescription : String,
//    viewModel: ListViewModel,
//    navigateBack: () -> Unit,
//    navigate: (name: String?, city: String?, image: Int?, desc: String?) -> Unit,
//) {
//    Scaffold(
//        modifier = modifier,
//        topBar = {
//            TopAppBarListDemo(title = title, navigate = { navigateBack() })
//        }
//    ) {
//        Column(modifier = Modifier.padding(it)) {
//            Box {
//                LazyRow(
//                    modifier = Modifier.padding(horizontal = 8.dp),
//                ) {
//                    items(3) {
//                        FilterChipSearchDemo(
//                            modifier = Modifier.padding(8.dp),
//                            label = "Jalur Pendaftaran"
//                        )
//                        FilterChipSearchDemo(modifier = Modifier.padding(8.dp), label = "Lokasi")
//                    }
//                }
//                AssistChipSearchDemo(
//                    label = "Filter",
//                    modifier = Modifier.padding(8.dp),
//                    icon = Icons.Default.Tune,
//                    onClick = { }
//                )
//            }
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2)
//            ) {
//                items(University.values()) { university ->
//                    CardListSearchDemo(
//                        nameCampus = university.universityName,
//                        ppp = university.universityName,
//                        image = university.universityImage,
//                        location = university.universityLocation,
//                        onClick = {
//                            navigate(
//                                university.universityName,
//                                university.universityLocation,
//                                university.universityImage,
//                                university.universityDescription,
//                            )
//                        },
//                    )
//                }
//            }
//        }
//
//    }
//}
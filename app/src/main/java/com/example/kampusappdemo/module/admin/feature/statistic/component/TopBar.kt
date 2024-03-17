package com.example.kampusappdemo.module.admin.feature.statistic.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.kampusappdemo.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatisticAdminTopBarDemo(){
    CenterAlignedTopAppBar(title = { Text(text = "Statistic") })
}
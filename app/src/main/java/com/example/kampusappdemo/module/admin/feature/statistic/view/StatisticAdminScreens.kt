package com.example.kampusappdemo.module.admin.feature.statistic.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.admin.feature.statistic.component.CardStatisticActivityAdminDemo
import com.example.kampusappdemo.module.admin.feature.statistic.component.CardStatisticIncomeAdminDemo
import com.example.kampusappdemo.module.admin.feature.statistic.component.CardStatisticInsightAdminDemo
import com.example.kampusappdemo.module.admin.feature.statistic.component.StatisticAdminTopBarDemo
import com.example.kampusappdemo.module.user.feature.payment.component.ListItemPaymentDetailDescriptionDemo
import com.example.kampusappdemo.navigation.Screens
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo

@Composable
fun StatisticAdminScreens() {
    SettingPreferences.typeUser = SettingPreferences.ADMIN
    Scaffold(
        topBar = { StatisticAdminTopBarDemo() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            CardStatisticIncomeAdminDemo()
            CardStatisticInsightAdminDemo()
            CardStatisticActivityAdminDemo()
        }
    }
}
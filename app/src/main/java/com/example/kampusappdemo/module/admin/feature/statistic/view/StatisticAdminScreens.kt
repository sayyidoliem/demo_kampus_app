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
            TextSubHeadlineDemo(
                modifier = Modifier.padding(start = 16.dp),
                text = "Income Results "
            )
            ElevatedCard(
                modifier = Modifier.padding(16.dp),
            ) {
                ListItem(
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    headlineContent = {
                        Text(
                            text = "From Visitor",
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    },
                    trailingContent = {
                        Text(
                            text = "Rp. 300.000,00",
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                )
                ListItem(
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    headlineContent = {
                        Text(
                            text = "From Registration",
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    },
                    trailingContent = {
                        Text(
                            text = "Rp. 300.000,00",
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                )
                ListItem(
                    colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    headlineContent = {
                        Text(
                            text = "From Teleconsultation",
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    },
                    trailingContent = {
                        Text(
                            text = "Rp. 300.000,00",
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                )
            }
            TextSubHeadlineDemo(modifier = Modifier.padding(start = 16.dp), text = "Insight")
            ElevatedCard(modifier = Modifier.padding(16.dp)) {
                ListItem(
                    headlineContent = {
                        Text(text = "Account Reached")
                    },
                    trailingContent = {
                        Text(text = "456")
                    }
                )
                ListItem(
                    headlineContent = {
                        Text(text = "Total Interaction")
                    },
                    trailingContent = {
                        Text(text = "456")
                    }
                )
                ListItem(
                    headlineContent = {
                        Text(text = "Total Program Study Launched")
                    },
                    trailingContent = {
                        Text(text = "1")
                    }
                )
                ListItem(
                    headlineContent = {
                        Text(text = "Most Favorite Study Program")
                    },
                    trailingContent = {
                        Text(text = "Keperawatan")
                    }
                )
            }
            TextSubHeadlineDemo(modifier = Modifier.padding(start = 16.dp), text = "Activity")
            ElevatedCard(modifier = Modifier.padding(16.dp)) {
                ListItem(
                    headlineContent = {
                        Text(text = "Visitor Student Waiting")
                    },
                    trailingContent = {
                        Text(text = "23")
                    }
                )
                ListItem(
                    headlineContent = {
                        Text(text = "Registration Student Waiting")
                    },
                    trailingContent = {
                        Text(text = "23")
                    }
                )
                ListItem(
                    headlineContent = {
                        Text(text = "Teleconsultation Student Waiting")
                    },
                    trailingContent = {
                        Text(text = "23")
                    }
                )
                ListItem(
                    headlineContent = {
                        Text(text = "Total Completed Student")
                    },
                    trailingContent = {
                        Text(text = "23")
                    }
                )
            }
        }
    }
}
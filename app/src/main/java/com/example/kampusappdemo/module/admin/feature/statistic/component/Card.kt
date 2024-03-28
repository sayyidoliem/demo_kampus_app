package com.example.kampusappdemo.module.admin.feature.statistic.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo

@Composable
fun CardStatisticIncomeAdminDemo(){
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
}

@Composable
fun CardStatisticInsightAdminDemo(){
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
}

@Composable
fun CardStatisticActivityAdminDemo(){
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
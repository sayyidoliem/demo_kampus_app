package com.example.kampusappdemo.module.admin.feature.chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.admin.feature.dashboard.component.SwitchDashboardAdminDemo
import com.example.kampusappdemo.module.admin.feature.dashboard.viewmodel.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDashboardAdminScreens(
    name: String,
    studyProgram: String,
    city: String,
    province: String,
    rating: String,
    image: Int,
    navigate: () -> Unit,
    viewModel: DashboardViewModel
) {
    ElevatedCard(modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 30.dp
        ),
        enabled = viewModel.enabled.value,
        onClick = { navigate() }) {
        ListItem(
            colors =
            ListItemDefaults.colors(
                disabledHeadlineColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            leadingContent = {
                Image(
                    modifier = Modifier.size(56.dp),
                    painter = painterResource(id = image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            },
            headlineContent = {
                Text(text = name)
            },
            supportingContent = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = studyProgram)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = "${city}, $province")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = rating)
                }
            },
            trailingContent = {
                SwitchDashboardAdminDemo(viewModel = viewModel)
            }
        )
    }
}
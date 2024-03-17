package com.example.kampusappdemo.module.admin.feature.dashboard.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.admin.feature.dashboard.component.AddDashboardDialog
import com.example.kampusappdemo.module.admin.feature.dashboard.component.SwitchDashboardAdminDemo
import com.example.kampusappdemo.module.admin.feature.dashboard.viewmodel.DashboardViewModel
import com.example.kampusappdemo.module.user.feature.profile.component.EditDocumentDialogLogin
import com.example.kampusappdemo.module.user.feature.profile.component.EditProfileDialog
import com.example.kampusappdemo.ui.component.TextTitleDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreens(navigate: (index: Int?) -> Unit, viewModel: DashboardViewModel) {
    val context = LocalContext.current

    val list = viewModel.filterDataByLastAdd(context)

    SettingPreferences.typeUser = SettingPreferences.ADMIN
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Dashboard") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.showDialog() },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextTitleDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "My School"
                    )
                    TextButton(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Edit")
                    }
                }

            }
            item {
                list.forEach { educationData ->
                    ElevatedCard(modifier = Modifier.padding(16.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 30.dp
                        ),
                        enabled = viewModel.enabled.value,
                        onClick = { navigate(educationData.id) }) {
                        ListItem(
                            colors =
                            ListItemDefaults.colors(
                                disabledHeadlineColor = MaterialTheme.colorScheme.secondaryContainer
                            ),
                            leadingContent = {
                                Image(
                                    modifier = Modifier.size(56.dp),
                                    painter = painterResource(id = ImageDummy[educationData.id].image),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop
                                )
                            },
                            headlineContent = {
                                Text(text = educationData.name)
                            },
                            supportingContent = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.School,
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(4.dp))
                                    Text(text = educationData.studyProgram)
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(4.dp))
                                    Text(text = "${educationData.location.city}, ${educationData.location.province}")
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(4.dp))
                                    Text(text = educationData.rating.toString())
                                }
                            },
                            trailingContent = {
                                SwitchDashboardAdminDemo(viewModel = viewModel)
                            }
                        )
                    }
                }
            }
            item {
                TextTitleDemo(modifier = Modifier.padding(horizontal = 16.dp), text = "Draft")
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(56.dp),
                    text = "Empty",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
    when {
        viewModel.openAddDialog.value -> {
            AddDashboardDialog(viewModel = viewModel)
        }
    }
}
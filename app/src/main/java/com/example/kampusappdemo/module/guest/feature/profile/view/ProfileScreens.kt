package com.example.kampusappdemo.module.guest.feature.profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.local.datastore.UserData
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.guest.feature.profile.component.BottomAppBarProfileDemo
import com.example.kampusappdemo.module.guest.feature.profile.component.EditDocumentDialogLogin
import com.example.kampusappdemo.module.guest.feature.profile.component.EditProfileDialog
import com.example.kampusappdemo.module.guest.feature.profile.component.ListItemOtherProfileDemo
import com.example.kampusappdemo.module.guest.feature.profile.component.LogOutConfirmationDialogProfile
import com.example.kampusappdemo.module.guest.feature.profile.component.TopAppBarProfileDemo
import com.example.kampusappdemo.module.guest.feature.profile.viewmodel.ProfileViewModel
import com.example.kampusappdemo.module.guest.feature.setting.component.ListItemDocumentProfileDemo
import com.example.kampusappdemo.ui.component.TextHeadlineDemo


@Composable
fun ProfileScreens(
    modifier: Modifier,
    viewModel: ProfileViewModel,
    navigate: () -> Unit,
    navigateToSetting: () -> Unit
) {

    val context = LocalContext.current

    val dataStore = UserData(context)

    dataStore.getUserName.collectAsState(initial = "").value?.let { viewModel.updateName(it) }

    dataStore.getUserPhone.collectAsState(initial = "").value?.let { viewModel.updatePhone(it) }

    dataStore.getUserEmail.collectAsState(initial = "").value?.let { viewModel.updateEmail(it) }

    viewModel.updateNameInstance(dataStore.getUserNameInstance.collectAsState(initial = "").value!!)

    viewModel.updateStudyProgram(dataStore.getUserProgram.collectAsState(initial = "").value!!)

    viewModel.updateCity(dataStore.getUserCity.collectAsState(initial = "").value!!)

    viewModel.updateProvince(dataStore.getUserProvince.collectAsState(initial = "").value!!)

    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = viewModel.list

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarProfileDemo()
        },
        bottomBar = {
            BottomAppBarProfileDemo(
                onClick = { viewModel.showLogOutDialog() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.padding(24.dp))
            ListItem(
                leadingContent = {
                    Image(
                        modifier = Modifier
                            .padding(12.dp)
                            .clip(CircleShape)
                            .size(72.dp),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                    )
                },
                headlineContent = {
                    Text(
                        text = viewModel.name.uppercase(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                supportingContent = {
                    Column {
                        Spacer(modifier = Modifier.padding(vertical = 4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Email, contentDescription = "")
                            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                            Text(
                                text = viewModel.email,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                            Text(text = viewModel.phone)
                        }
                    }
                },
                trailingContent = {
                    IconButton(onClick = { viewModel.showDialog() }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                    }
                },
                shadowElevation = 16.dp
            )
            Spacer(modifier = Modifier.padding(16.dp))
            if (SettingPreferences.typeUser == SettingPreferences.USER) {
                TabRow(
                    selectedTabIndex = selectedIndex,
                    containerColor = MaterialTheme.colorScheme.surface,
                ) {
                    list.forEachIndexed { index, text ->
                        val selected = selectedIndex == index
                        Tab(
                            selected = selected,
                            onClick = { selectedIndex = index },
                            text = {
                                Text(
                                    text = text,
                                    color =
                                    if (selected) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    }
                                )
                            })
                    }
                }
                when (selectedIndex) {
                    0 -> {
                        ListItemOtherProfileDemo(
                            headLineText = "Settings",
                            icon = Icons.Default.Settings,
                            onClick = { navigateToSetting() })
                        ListItemOtherProfileDemo(
                            headLineText = "Help",
                            icon = Icons.Default.Help,
                            onClick = {})
                        ListItemOtherProfileDemo(
                            headLineText = "FAQ",
                            icon = Icons.Default.Info,
                            onClick = {})
                        ListItemOtherProfileDemo(
                            headLineText = "Terms & Condition",
                            icon = Icons.Default.Task,
                            onClick = {})
                        ListItemOtherProfileDemo(
                            headLineText = "Privacy",
                            icon = Icons.Default.PrivacyTip,
                            onClick = {})
                    }

                    1 -> {
                        ListItemDocumentProfileDemo(
                            headLineText = "Diploma Document",
                            supportText = viewModel.document,
                            icon = Icons.Default.AttachFile,
                            onClick = { viewModel.showDocumentDialog() }
                        )
                        ListItemDocumentProfileDemo(
                            headLineText = "Certificate Document",
                            supportText = viewModel.document,
                            icon = Icons.Default.AttachFile,
                            onClick = { viewModel.showDocumentDialog() }
                        )
                        ListItemDocumentProfileDemo(
                            headLineText = "Other Document",
                            supportText = viewModel.document,
                            icon = Icons.Default.AttachFile,
                            onClick = { viewModel.showDocumentDialog() }
                        )
                        ListItemDocumentProfileDemo(
                            headLineText = "Other Document",
                            supportText = viewModel.document,
                            icon = Icons.Default.AttachFile,
                            onClick = { viewModel.showDocumentDialog() }
                        )
                    }
                }

            }
            if (SettingPreferences.typeUser == SettingPreferences.ADMIN) {
                ListItemOtherProfileDemo(
                    headLineText = "Settings",
                    icon = Icons.Default.Settings,
                    onClick = { navigateToSetting() })
                ListItemOtherProfileDemo(
                    headLineText = "Help",
                    icon = Icons.Default.Help,
                    onClick = {})
                ListItemOtherProfileDemo(
                    headLineText = "FAQ",
                    icon = Icons.Default.Info,
                    onClick = {})
                ListItemOtherProfileDemo(
                    headLineText = "Terms & Condition",
                    icon = Icons.Default.Task,
                    onClick = {})
                ListItemOtherProfileDemo(
                    headLineText = "Privacy",
                    icon = Icons.Default.PrivacyTip,
                    onClick = {})
            }
        }
    }
    when {
        viewModel.openEditDialog.value -> {
            EditProfileDialog(context = context, viewModel = viewModel)
        }

        viewModel.openDocumentDialog.value -> {
            EditDocumentDialogLogin(viewModel = viewModel)
        }

        viewModel.openLogOutDialog.value -> {
            LogOutConfirmationDialogProfile(navigate = navigate, viewModel = viewModel)
        }
    }
}
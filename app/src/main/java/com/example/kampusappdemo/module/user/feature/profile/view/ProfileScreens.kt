package com.example.kampusappdemo.module.user.feature.profile.view

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.user.feature.profile.component.BottomAppBarProfileDemo
import com.example.kampusappdemo.module.user.feature.profile.component.EditDocumentDialogLogin
import com.example.kampusappdemo.module.user.feature.profile.component.EditProfileDialog
import com.example.kampusappdemo.module.user.feature.profile.component.ListItemIndentitySettingDemo
import com.example.kampusappdemo.module.user.feature.profile.component.TopAppBarProfileDemo
import com.example.kampusappdemo.module.user.feature.profile.viewmodel.ProfileViewModel
import com.example.kampusappdemo.module.user.feature.setting.component.ListItemDocumentSettingDemo


@Composable
fun ProfileScreens(
    modifier: Modifier,
    name: String,
    phone: String,
    email: String,
    nameInstance: String,
    studyProgram: String,
    city: String,
    province: String,
    viewModel: ProfileViewModel,
    navigate: () -> Unit
) {
    viewModel.updateName(name)
    viewModel.updatePhone(phone)
    viewModel.updateEmail(email)
    viewModel.updateNameInstance(nameInstance)
    viewModel.updateStudyProgram(studyProgram)
    viewModel.updateCity(city)
    viewModel.updateProvince(province)

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarProfileDemo(onClick = {
                navigate()
            })
        },
        bottomBar = {
            BottomAppBarProfileDemo(
                onClick = { viewModel.showDialog() }
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
                            .padding(16.dp)
                            .clip(CircleShape)
                            .size(72.dp),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                    )
                },
                headlineContent = { Text(text = "User") },
                supportingContent = {
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "")
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                        Text(text = viewModel.email)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                        Text(text = viewModel.phone)
                    }
                },
                shadowElevation = 16.dp
            )
            Spacer(modifier = Modifier.padding(16.dp))
            if (nameInstance.isNotEmpty()) {
                ListItemIndentitySettingDemo(
                    headLineText = "Name Instance",
                    supportText = nameInstance
                )
                ListItemIndentitySettingDemo(
                    headLineText = "StudyProgram",
                    supportText = studyProgram
                )
                ListItemIndentitySettingDemo(
                    headLineText = "City",
                    supportText = city
                )
                ListItemIndentitySettingDemo(
                    headLineText = "Province",
                    supportText = province
                )
            }
            ListItemDocumentSettingDemo(
                headLineText = "Diploma Document",
                supportText = viewModel.document,
                icon = Icons.Default.AttachFile,
                onClick = { viewModel.showDocumentDialog() }
            )
            ListItemDocumentSettingDemo(
                headLineText = "Certificate Document",
                supportText = viewModel.document,
                icon = Icons.Default.AttachFile,
                onClick = { viewModel.showDocumentDialog() }
            )
            ListItemDocumentSettingDemo(
                headLineText = "Other Document",
                supportText = viewModel.document,
                icon = Icons.Default.AttachFile,
                onClick = { viewModel.showDocumentDialog() }
            )
            ListItemDocumentSettingDemo(
                headLineText = "Other Document",
                supportText = viewModel.document,
                icon = Icons.Default.AttachFile,
                onClick = { viewModel.showDocumentDialog() }
            )
        }
    }
    when {
        viewModel.openEditDialog.value -> {
            EditProfileDialog(viewModel = viewModel)
        }

        viewModel.openDocumentDialog.value -> {
            EditDocumentDialogLogin(viewModel = viewModel)
        }
    }
}
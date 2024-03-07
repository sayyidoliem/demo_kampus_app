package com.example.kampusappdemo.module.user.feature.profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material3.Scaffold
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
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            ListItemIndentitySettingDemo(
                headLineText = "Name",
                supportText = viewModel.name
            )
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
            ListItemIndentitySettingDemo(
                headLineText = "Phone Number",
                supportText = viewModel.phone
            )
            ListItemIndentitySettingDemo(
                headLineText = "E - Mail",
                supportText = viewModel.email
            )
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
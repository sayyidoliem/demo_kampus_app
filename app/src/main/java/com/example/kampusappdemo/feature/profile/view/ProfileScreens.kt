package com.example.kampusappdemo.feature.profile.view

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
import com.example.kampusappdemo.feature.profile.viewmodel.ProfileViewModel
import com.example.kampusappdemo.feature.profile.component.BottomAppBarProfileDemo
import com.example.kampusappdemo.feature.profile.component.EditProfileDialog
import com.example.kampusappdemo.feature.profile.component.ListItemIndentitySettingDemo
import com.example.kampusappdemo.feature.profile.component.TopAppBarProfileDemo
import com.example.kampusappdemo.feature.setting.component.ListItemDocumentSettingDemo


@Composable
fun ProfileScreens(
    modifier: Modifier,
    viewModel: ProfileViewModel,
    navigate: () -> Unit
) {
    val nameDummy = "aaa"
    val phoneDummy = "0000000"
    val emailDummy = "balbalblba@gmail.com"
    val documentDummy = "rarrwrwr.pdf"
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
                supportText = nameDummy
            )
            ListItemIndentitySettingDemo(
                headLineText = "Phone Number",
                supportText = phoneDummy
            )
            ListItemIndentitySettingDemo(
                headLineText = "E - Mail",
                supportText = emailDummy
            )
            ListItemDocumentSettingDemo(
                headLineText = "Diploma Document",
                supportText = documentDummy,
                icon = Icons.Default.AttachFile
            )
            ListItemDocumentSettingDemo(
                headLineText = "Certificate Document",
                supportText = documentDummy,
                icon = Icons.Default.AttachFile
            )
            ListItemDocumentSettingDemo(
                headLineText = "Other Document",
                supportText = documentDummy,
                icon = Icons.Default.AttachFile
            )
            ListItemDocumentSettingDemo(
                headLineText = "Other Document",
                supportText = documentDummy,
                icon = Icons.Default.AttachFile
            )
        }
    }
    when {
        viewModel.openEditDialog.value -> {
            EditProfileDialog(openDialog = { viewModel.hideDialog() })
        }
    }
}
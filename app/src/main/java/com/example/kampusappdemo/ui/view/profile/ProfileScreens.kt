package com.example.kampusappdemo.ui.view.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.ui.component.BottomAppBarProfileDemo
import com.example.kampusappdemo.ui.component.CardProfileDemo
import com.example.kampusappdemo.ui.component.EditProfileDialog
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import com.example.kampusappdemo.ui.component.TopAppBarProfileDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreens(
    modifier: Modifier,
    viewModel: ProfileViewModel
) {
    val openDialog by remember {
        mutableStateOf(false)
    }
    Scaffold(
        modifier = modifier,
        topBar = {
                 TopAppBarProfileDemo(onClick = {

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
            ListItem(
                headlineContent = {
                    Text(text = "Name")
                },
                supportingContent = {
                    Text(text = "Aksa Akakaak")
                }
            )
            Divider()
            ListItem(
                headlineContent = {
                    Text(text = "Phone Number")
                },
                supportingContent = {
                    Text(text = "+123 - 4567 - 8910")
                }
            )
            Divider()
            ListItem(
                headlineContent = {
                    Text(text = "E - Mail")
                },
                supportingContent = {
                    Text(text = "Blablabla@gmail.com")
                },
            )
        }
    }
    when {
        viewModel.openEditDialog.value -> {
            EditProfileDialog(openDialog = { viewModel.hideDialog() })
        }
    }
}
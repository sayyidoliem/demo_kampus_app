package com.example.kampusappdemo.module.admin.feature.dashboard.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.admin.feature.dashboard.component.EditDashboardDialog
import com.example.kampusappdemo.module.admin.feature.dashboard.viewmodel.DashboardViewModel
import com.example.kampusappdemo.module.user.feature.detail.component.FilterChipDetailDemo
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo

@Composable
fun DetailDashboardScreens(index: Int, navigateUp: () -> Unit, viewModel: DashboardViewModel) {
    val context = LocalContext.current

    val finalDataList = viewModel.dataAtIndex(context, index)

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = { viewModel.showDialog() }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            finalDataList!!
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = ImageDummy[index].image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background.copy(alpha = 0.2F)),
                    onClick = { navigateUp() }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextTitleDemo(
                    modifier = Modifier,
                    text = finalDataList.instance
                )
                Spacer(modifier = Modifier.padding(4.dp))
                TextTitleDemo(
                    modifier = Modifier,
                    text = finalDataList.name
                )
                Box(modifier = Modifier.fillMaxWidth()) {
                    FilterChipDetailDemo(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        label = finalDataList.studyProgram
                    )
                }

            }
            Row(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = finalDataList.rating.toString())
            }
            Row(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
                Icon(imageVector = Icons.Default.Place, contentDescription = "")
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = "${finalDataList.location.district}, ${finalDataList.location.city}, ${finalDataList.location.province}")
            }
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Type Campus"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = finalDataList.instance
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "About College"
            )
            finalDataList.description.forEachIndexed { index, text ->
                val id = index + 1
                TextParagraphDemo(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = "${id}. $text"
                )
            }
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Terms & Condition"
            )
            finalDataList.termsCondition.forEachIndexed { index, text ->
                val id = index + 1
                TextParagraphDemo(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = "${id}. $text"
                )
            }
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Service Fee"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = "Visit : ${finalDataList.visit}"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = "TeleConsultation : ${finalDataList.teleConsultation}"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                text = "Registration : ${finalDataList.register}"
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Contacts"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = "E-Mail : ${finalDataList.emails}"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(start = 16.dp),
                text = "Website : ${finalDataList.website}"
            )
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
    when {
        viewModel.openAddDialog.value-> {
            EditDashboardDialog(viewModel = viewModel)
        }
    }
}
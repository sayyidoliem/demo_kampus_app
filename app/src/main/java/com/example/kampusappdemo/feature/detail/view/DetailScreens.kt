package com.example.kampusappdemo.feature.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kampusappdemo.feature.detail.viewmodel.DetailViewmodel
import com.example.kampusappdemo.feature.detail.component.BottomAppBarDetailDemo
import com.example.kampusappdemo.feature.detail.component.FABChat
import com.example.kampusappdemo.feature.detail.component.FilterChipDetailDemo
import com.example.kampusappdemo.feature.detail.component.SuccessDialogDemo
import com.example.kampusappdemo.feature.detail.component.TermsConditionDialog
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo

@Composable
fun DetailScreens(
    modifier: Modifier,
    navigateUp: () -> Unit,
    navigate: () -> Unit,
    index: Int,
    viewModel: DetailViewmodel
) {
    val context = LocalContext.current

    val finalDataList = viewModel.dataAtIndex(context, index)

    val registerEnabled by remember {
        mutableStateOf(true)
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomAppBarDetailDemo(
                onClickFAQ = { /*TODO*/ },
                onClickRegister = {
                    viewModel.showConfirmationDialog()
                },
                registerEnabled = registerEnabled
            )
        },
        floatingActionButton = {
            FABChat(navigate = { navigate() })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            finalDataList!!
            Box {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = finalDataList.image,
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
                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background.copy(alpha = 0.4F)),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
            Row(modifier = Modifier.padding(16.dp)) {
                TextTitleDemo(
                    modifier = Modifier,
                    text = finalDataList.instance
                )
                Spacer(modifier = Modifier.padding(2.dp))
                TextTitleDemo(
                    modifier = Modifier,
                    text = finalDataList.name
                )
            }
            Row(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Yellow)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = finalDataList.rating.toString())
            }
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 4.dp, start = 16.dp),
                text = "Study Program"
            )
            FilterChipDetailDemo(
                modifier = Modifier.padding(8.dp),
                label = finalDataList.studyProgram
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Type Campus"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = finalDataList.instance
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Location"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = "${finalDataList.location.city}, ${finalDataList.location.province}"
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "About College"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = finalDataList.description.toString()
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
        }

    }
    when {
        viewModel.openSuccessDialog.value -> {
            SuccessDialogDemo(
                onDismissRequest = {
                    viewModel.hideSuccessDialog()
                    viewModel.hideConfirmationDialog()
                },
                onConfirmation = {
                    viewModel.hideSuccessDialog()
                    viewModel.hideConfirmationDialog()
                    !registerEnabled
                },
                dialogTitle = "Success",
                dialogText = "You have successfully registered"
            )
        }

        viewModel.openConfirmation.value -> {
            TermsConditionDialog(
                openDialog = { viewModel.hideConfirmationDialog() },
                onConfirmation = {
                    viewModel.showSuccessDialog()
                },
                text = finalDataList!!.termsCondition[2]
            )
        }
    }
}
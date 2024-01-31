package com.example.kampusappdemo.ui.view.detail

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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kampusappdemo.ui.component.BottomAppBarDetailDemo
import com.example.kampusappdemo.ui.component.FABChat
import com.example.kampusappdemo.ui.component.FilterChipSearchDemo
import com.example.kampusappdemo.ui.component.SuccessDialogDemo
import com.example.kampusappdemo.ui.component.TermsConditionDialog
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo

@Composable
fun DetailScreens(
    modifier: Modifier,
    navigateUp: () -> Unit,
    navigate: () -> Unit,
    nameUniversity: String,
    typeUniversity: String,
    ratingUniversity: Float,
    nameCity: String,
    imageUniversity: String,
    nameDescription: String,
    emailUniversity: String,
    websiteUniversity: String,
    viewModel: DetailViewmodel
) {
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
            Box {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = imageUniversity,
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
                    text = typeUniversity
                )
                Spacer(modifier = Modifier.padding(2.dp))
                TextTitleDemo(
                    modifier = Modifier,
                    text = nameUniversity
                )
            }
            Row(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Color.Yellow)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = ratingUniversity.toString())
            }
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 4.dp, start = 16.dp),
                text = "Study Program Options"
            )
            Row(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                FilterChipSearchDemo(
                    modifier = Modifier.padding(8.dp),
                    label = "Strata"
                )
                FilterChipSearchDemo(
                    modifier = Modifier.padding(8.dp),
                    label = "Vokasi"
                )
                FilterChipSearchDemo(
                    modifier = Modifier.padding(8.dp),
                    label = "Diploma"
                )
            }
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Type Campus"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = typeUniversity
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Location"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = nameCity
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "About College"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = nameDescription
            )
            Divider(thickness = 4.dp)
            TextHeadlineDemo(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Contacts"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(16.dp),
                text = "E-Mail : $emailUniversity"
            )
            TextParagraphDemo(
                modifier = Modifier.padding(start = 16.dp),
                text = "Website : $websiteUniversity"
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
                dialogTitle = "Succsess",
                dialogText = "You have successfully registered"
            )
        }

        viewModel.openConfirmation.value -> {
            TermsConditionDialog(
                openDialog = { viewModel.hideConfirmationDialog() },
                onConfirmation = {
                    viewModel.showSuccessDialog()
                },
            )
        }
    }
}
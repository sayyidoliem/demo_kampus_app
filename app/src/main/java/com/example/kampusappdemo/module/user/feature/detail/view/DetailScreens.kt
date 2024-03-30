package com.example.kampusappdemo.module.user.feature.detail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.user.feature.detail.component.BottomAppBarDetailDemo
import com.example.kampusappdemo.module.user.feature.detail.component.FABChat
import com.example.kampusappdemo.module.user.feature.detail.component.FAQDialog
import com.example.kampusappdemo.module.user.feature.detail.component.FilterChipDetailDemo
import com.example.kampusappdemo.module.user.feature.detail.component.SignInDetailDialog
import com.example.kampusappdemo.module.user.feature.detail.component.SuccessDialogDemo
import com.example.kampusappdemo.module.user.feature.detail.component.TermsConditionDialog
import com.example.kampusappdemo.module.user.feature.detail.viewmodel.DetailViewmodel
import com.example.kampusappdemo.module.user.feature.home.component.SignInHomeDialog
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import com.example.kampusappdemo.ui.component.TextTitleDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreens(
    modifier: Modifier,
    navigateToSignIn: () -> Unit,
    navigateToComparison: (index : Int?) -> Unit,
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
                onClickFAQ = {
                    if (SettingPreferences.typeUser == SettingPreferences.GUEST) {
                        viewModel.showDialog()
                    } else {
                        viewModel.showFAQDialog()
                    }
                },
                onClickRegister = {
                    if (SettingPreferences.typeUser == SettingPreferences.GUEST) {
                        viewModel.showDialog()
                    } else {
                        viewModel.showConfirmationDialog()
                    }
                },
                registerEnabled = registerEnabled
            )
        },
        floatingActionButton = {
            FABChat(navigate = {
                if (SettingPreferences.typeUser == SettingPreferences.GUEST) {
                    viewModel.showDialog()
                } else {
                    navigate()
                }
            })
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
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .sizeIn(minHeight = 100.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                ),
                onClick = { navigateToComparison(finalDataList.id) }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .sizeIn(minHeight = 100.dp)
                ) {
                    Text(modifier = Modifier.align(Alignment.Center), text = "Comparison")
                }
            }
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
                textRequirement = finalDataList!!.termsCondition,
                textTermsCondition = finalDataList.requirement
            )
        }

        viewModel.openFAQ.value -> {
            FAQDialog(
                openDialog = { viewModel.hideFAQDialog() },
                textTeleConsultation = finalDataList!!.teleConsultation,
                textRegister = finalDataList.register,
                textVisit = finalDataList.visit,
                onRegisterClick = {},
                onTeleconsultationClick = {},
                onVisitClick = {}
            )
        }

        viewModel.openSignInDialog.value -> {
            SignInDetailDialog(navigate = { navigateToSignIn() }, viewModel = viewModel)
        }
    }
}
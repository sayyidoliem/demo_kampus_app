package com.example.kampusappdemo.module.user.feature.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.University
import com.example.kampusappdemo.module.user.feature.detail.viewmodel.DetailViewmodel
import com.example.kampusappdemo.module.user.feature.home.viewmodel.HomeViewModel
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextParagraphDemo

@Composable
fun SuccessDialogDemo(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        icon = {
            Icon(
                modifier = Modifier.size(56.dp),
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Example Icon"
            )
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = dialogText,
                textAlign = TextAlign.Center
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Close")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsConditionDialog(
    openDialog: () -> Unit,
    onConfirmation: () -> Unit,
    textRequirement: List<String>,
    textTermsCondition: List<String>
) {
    val (checkedState, onStateChange) = remember { mutableStateOf(false) }
    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = { openDialog() }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = when (SettingPreferences.isSelectedLanguage) {
                                SettingPreferences.ENGLISH -> {
                                    "Terms & Condition"
                                }

                                else -> {
                                    "Syarat dan Ketentuan"
                                }
                            },
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { openDialog() }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    },
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.surface),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    TextHeadlineDemo(modifier = Modifier, text = "Requirement")
                    Spacer(modifier = Modifier.padding(8.dp))
                    textRequirement.forEachIndexed { index, requirement ->
                        val id = index + 1
                        TextParagraphDemo(
                            modifier = Modifier,
                            text = "${id}. $requirement"
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextHeadlineDemo(modifier = Modifier, text = "Terms and Condition")
                    Spacer(modifier = Modifier.padding(8.dp))
                    textTermsCondition.forEachIndexed { index, termsCondition ->
                        val id = index + 1
                        TextParagraphDemo(
                            modifier = Modifier,
                            text = "${id}. $termsCondition"
                        )
                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "I have read the terms and condition")
                        Checkbox(
                            checked = checkedState,
                            onCheckedChange = { onStateChange(!checkedState) } // null recommended for accessibility with screenreaders
                        )
                    }
                    Button(
                        modifier = Modifier.align(Alignment.End),
                        enabled = checkedState,
                        onClick = { onConfirmation() }
                    ) {
                        Text(text = "Register")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQDialog(
    openDialog: () -> Unit,
    textTeleConsultation: Double,
    textVisit: Double,
    textRegister: Double,
    onTeleconsultationClick: (click: Double) -> Unit,
    onVisitClick: (click: Double) -> Unit,
    onRegisterClick: (click: Double) -> Unit
) {
    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = { openDialog() }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = when (SettingPreferences.isSelectedLanguage) {
                                SettingPreferences.ENGLISH -> {
                                    "Frequently Asked Questions "
                                }

                                else -> {
                                    "Pertanyaan yang sering "
                                }
                            },
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { openDialog() }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null
                            )
                        }
                    },
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.surface),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    TextHeadlineDemo(modifier = Modifier, text = "Teleconsultation")
                    Spacer(modifier = Modifier.padding(4.dp))
                    TextParagraphDemo(
                        modifier = Modifier,
                        text = University.KAMPUS_1.universityDescription
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Button(
                        modifier = Modifier.align(Alignment.End),
                        onClick = { onTeleconsultationClick(textTeleConsultation) }) {
                        Text(text = "Rp. ${textTeleConsultation}00")
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextHeadlineDemo(modifier = Modifier, text = "Visit")
                    Spacer(modifier = Modifier.padding(4.dp))
                    TextParagraphDemo(
                        modifier = Modifier,
                        text = University.KAMPUS_1.universityDescription
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Button(
                        modifier = Modifier.align(Alignment.End),
                        onClick = { onVisitClick(textVisit) }) {
                        Text(text = "Rp. ${textVisit}00")
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextHeadlineDemo(modifier = Modifier, text = "Register")
                    Spacer(modifier = Modifier.padding(4.dp))
                    TextParagraphDemo(
                        modifier = Modifier,
                        text = University.KAMPUS_1.universityDescription
                    )
                    Button(
                        modifier = Modifier.align(Alignment.End),
                        onClick = { onRegisterClick(textRegister) }) {
                        Text(text = "Rp. ${textRegister}00")
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun SignInDetailDialog(navigate : () -> Unit, viewModel: DetailViewmodel){
    AlertDialog(
        icon = {
            Icon(imageVector = Icons.Default.Warning, contentDescription = "")
        },
        title = {
            Text(text = "Need Sign In")
        },
        text = {
            Text(text = "Please sign in to use the other feature from SCOLA : A Privilege")
        },
        onDismissRequest = { viewModel.hideDialog() },
        confirmButton = {
            Button(onClick = { navigate()}) {
                Text(text = "Sign In")
            }
        },
        dismissButton = {
            TextButton(onClick = { viewModel.hideDialog() }) {
                Text(text = "Dissmiss")
            }
        }
    )
}
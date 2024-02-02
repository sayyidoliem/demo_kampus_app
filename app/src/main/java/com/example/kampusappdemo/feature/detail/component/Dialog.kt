package com.example.kampusappdemo.feature.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
    text : String
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
                    TextHeadlineDemo(modifier = Modifier, text = "Terms and Condition")
                    TextParagraphDemo(
                        modifier = Modifier,
                        text = text
                    )
                    Row(modifier = Modifier.align(Alignment.End).padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
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

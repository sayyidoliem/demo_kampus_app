package com.example.kampusappdemo.module.guest.feature.login.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun InsertImageDialogLogin(
    openDialog: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(Icons.Default.Image, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Upload Image")
        },
        text = {
            Column {
                Text(text = "Submit your image for profile photo")
                Spacer(modifier = Modifier.padding(8.dp))
                SmallFloatingActionButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Upload, contentDescription = "")
                }
            }
        },
        onDismissRequest = {
            openDialog()
        },
        confirmButton = {
            Button(
                onClick = {
                    openDialog()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Composable
fun InsertStudyProgramDialogLogin(
    openDialog: () -> Unit,
) {
    var text by remember { mutableStateOf("") }
    AlertDialog(
        icon = {
            Icon(Icons.Default.School, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Specific Study")
        },
        text = {
            Column {
                Text(text = "What Your Study Program?")
                Spacer(modifier = Modifier.padding(8.dp))
                OutlinedTextField(value = text, onValueChange = { text = it })
            }
        },
        onDismissRequest = {
            openDialog()
        },
        confirmButton = {
            Button(
                onClick = {
                    openDialog()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
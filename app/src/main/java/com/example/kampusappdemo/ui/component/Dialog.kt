package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kampusappdemo.data.kotpref.SettingPreferences

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
fun EditProfileDialog(
    openDialog: () -> Unit
) {
    var openDialoga by remember { mutableStateOf(false) }
    var textEmail by rememberSaveable { mutableStateOf("") }
    var textPhone by rememberSaveable { mutableStateOf("") }
    var textMessage by rememberSaveable { mutableStateOf("") }

    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = { openDialog() }
    ) {
        // In order to make the dialog full screen, we need to use
        // Modifier.fillMaxSize()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = when (SettingPreferences.isSelectedLanguage) {

                                SettingPreferences.ENGLISH -> {
                                    "Edit Profile"
                                }

                                else -> {
                                    "Edit profil"
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
                var emailDeveloper = "sayyid.olim12@gmail.com"
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxSize()
                ) {
                    //name
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        value = emailDeveloper,
                        onValueChange = { emailDeveloper = it },
                        label = {
                            Text(
                                when (SettingPreferences.isSelectedLanguage) {
                                    SettingPreferences.ENGLISH -> {
                                        "Full Name"
                                    }

                                    else -> {
                                        "Nama Lengkap"
                                    }
                                },
                            )
                        },
                    )
                    //e-mail
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(
                            autoCorrect = true,
                            keyboardType = KeyboardType.Email,
                        ),
                        value = textEmail,
                        onValueChange = { textEmail = it },
                        placeholder = {
                            Text(text = "example@example.com")
                        },
                        label = {
                            Text(text = "E-Mail")
                        }
                    )
                    //phone
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        keyboardOptions = KeyboardOptions(
                            autoCorrect = true,
                            keyboardType = KeyboardType.Phone,
                        ),
                        value = textPhone,
                        onValueChange = { textPhone = it },
                        placeholder = {
                            Text(
                                text = "+62 123 4567 8910"
                            )
                        },
                        label = {
                            Text(
                                when (SettingPreferences.isSelectedLanguage) {
                                    SettingPreferences.ENGLISH -> {
                                        "Phone Number"
                                    }

                                    else -> {
                                        "Nomer Telepon"
                                    }
                                },
                            )
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f)
                            .padding(horizontal = 16.dp),
                        value = textMessage,
                        onValueChange = { textMessage = it },
                        label = {
                            Text(
                                when (SettingPreferences.isSelectedLanguage) {
                                    SettingPreferences.ENGLISH -> {
                                        "Pesan"
                                    }

                                    else -> {
                                        "Message"
                                    }
                                },
                            )
                        },
                    )
                    Button(
                        onClick = { // TODO: send value to profile again
                             },
                        Modifier
                            .align(Alignment.End)
                            .padding(end = 16.dp, bottom = 16.dp, top = 8.dp)
                    ) {
                        Text(
                            when (SettingPreferences.isSelectedLanguage) {
                                SettingPreferences.ENGLISH -> {
                                    "Save"
                                }

                                else -> {
                                    "Simpan"
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}
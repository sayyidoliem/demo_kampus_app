package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.kampusappdemo.data.local.database.University
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

@Composable
fun ChangeTranslateDialogDemo(
    openDialog: () -> Unit
) {
    val radioOptions = listOf("English", "Indonesian")
    var selectedOption by remember { mutableIntStateOf(SettingPreferences.isSelectedLanguage) }
    AlertDialog(
        onDismissRequest = { openDialog() },
        title = { Text(text = "Select Language") },
        icon = { Icon(imageVector = Icons.Default.Language, contentDescription = null) },
        text = {
            Column {
                radioOptions.forEachIndexed { index, option ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (index == selectedOption),
                            onClick = {
                                selectedOption = index
                                SettingPreferences.isSelectedLanguage = index
                            }
                        )
                        TextButton(onClick = {
                            selectedOption = index
                            SettingPreferences.isSelectedLanguage = index
                        }) {
                            Text(
                                text = option,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { openDialog() }) {
                Text("Confirm")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsConditionDialog(
    openDialog: () -> Unit,
    onConfirmation: () -> Unit,
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
                    TextHeadlineDemo(modifier = Modifier, text = "Terms")
                    TextParagraphDemo(
                        modifier = Modifier,
                        text = "Lorem Ipsum Dolor sit amet bkgweeeeee"
                    )
                    TextHeadlineDemo(modifier = Modifier, text = "Terms")
                    TextParagraphDemo(
                        modifier = Modifier,
                        text = University.KAMPUS_1.universityDescription
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

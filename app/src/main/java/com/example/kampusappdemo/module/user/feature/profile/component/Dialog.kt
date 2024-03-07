package com.example.kampusappdemo.module.user.feature.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.user.feature.profile.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileDialog(
    viewModel: ProfileViewModel
) {
    val scrollState = rememberScrollState()
    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = {
            viewModel.showConfirmationDialog()
        }
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
                        IconButton(onClick = { viewModel.showConfirmationDialog() }) {
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
                    verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = scrollState)
                ) {
                    Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Image(
                            modifier = Modifier
                                .padding(16.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                        IconButton(
                            modifier = Modifier.align(Alignment.Center),
                            onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = ""
                            )
                        }

                    }
                    //name
                    TextFieldEditProfileDemo(
                        value = viewModel.name,
                        onValueChange = { viewModel.name = it },
                        label = "Name",
                        placeholder = "user",
                        trailingIcon = Icons.Default.Person
                    )
                    //e-mail
                    TextFieldEditProfileDemo(
                        value = viewModel.email,
                        onValueChange = { viewModel.email = it },
                        keyboardType = KeyboardType.Email,
                        label = "E-Mail",
                        placeholder = "example@gmail.com",
                        trailingIcon = Icons.Default.Email
                    )
                    //phone
                    TextFieldEditProfileDemo(
                        value = viewModel.phone,
                        onValueChange = { viewModel.phone = it },
                        keyboardType = KeyboardType.Phone,
                        label = "Phone Number",
                        placeholder = "+62 123 4567 8910",
                        trailingIcon = Icons.Default.Phone
                    )
                    if (viewModel.nameInstance.isNotEmpty()) {
                        TextFieldEditProfileDemo(
                            value = viewModel.nameInstance,
                            onValueChange = { viewModel.nameInstance = it },
                            label = "Name Instance",
                            placeholder = "university",
                            trailingIcon = Icons.Default.School
                        )
                        TextFieldEditProfileDemo(
                            value = viewModel.studyProgram,
                            onValueChange = { viewModel.studyProgram = it },
                            label = "Study Program",
                            placeholder = "general",
                            trailingIcon = Icons.Default.School
                        )
                        TextFieldEditProfileDemo(
                            value = viewModel.city,
                            onValueChange = { viewModel.city = it },
                            label = "City",
                            placeholder = "Depok",
                            trailingIcon = Icons.Default.Place
                        )
                        TextFieldEditProfileDemo(
                            value = viewModel.province,
                            onValueChange = { viewModel.province = it },
                            label = "Province",
                            placeholder = "Banten",
                            trailingIcon = Icons.Default.Place
                        )
                    }
                    Button(
                        onClick = {
                            viewModel.hideDialog()
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
    when {
        viewModel.openConfirmationDialog.value -> {
            ConfirmationChangeDialog(viewModel = viewModel)
        }
    }
}

@Composable
fun ConfirmationChangeDialog(
    viewModel: ProfileViewModel
) {
    AlertDialog(
        icon = {
            Icon(Icons.Default.PriorityHigh, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Discard Changes?")
        },
        text = {
            Text(text = "Editing profile has been unsaved. Are you want discard changes?")
        },
        onDismissRequest = {
            viewModel.hideConfirmationDialog()
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.hideConfirmationDialog()
                    viewModel.hideDialog()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.hideConfirmationDialog()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Composable
fun EditDocumentDialogLogin(
    viewModel: ProfileViewModel
) {
    AlertDialog(
        icon = {
            Icon(Icons.Default.AttachFile, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Upload Document")
        },
        text = {
            Column {
                Text(text = "Submit your document for profile photo")
                Spacer(modifier = Modifier.padding(8.dp))
                SmallFloatingActionButton(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Upload, contentDescription = "")
                }
            }
        },
        onDismissRequest = {
            viewModel.hideDocumentDialog()
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.hideDocumentDialog()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.hideDocumentDialog()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
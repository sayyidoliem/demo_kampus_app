package com.example.kampusappdemo.module.admin.feature.dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PriceChange
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.admin.feature.dashboard.viewmodel.DashboardViewModel
import com.example.kampusappdemo.module.guest.feature.login.component.InsertImageDialogLogin
import com.example.kampusappdemo.module.guest.feature.login.component.InsertStudyProgramDialogLogin
import com.example.kampusappdemo.module.guest.feature.login.component.StudyProgramRadioButtonDemo
import com.example.kampusappdemo.module.guest.feature.login.component.TextFieldLocationLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDashboardDialog(
    viewModel: DashboardViewModel
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
                                    "Add"
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
                    TextFieldDashboardAdminDemo(
                        value = viewModel.schoolName,
                        onValueChange = { school -> viewModel.updateUser(school) },
                        label = "School Name",
                        placeholder = "your name",
                        keyboardType = KeyboardType.Text,
                        trailingIcon = Icons.Default.Person
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.phone,
                        onValueChange = { phone -> viewModel.updatePhone(phone) },
                        label = "Phone",
                        placeholder = "+62 1234 5678",
                        keyboardType = KeyboardType.Phone,
                        trailingIcon = Icons.Default.Phone
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.email,
                        onValueChange = { email -> viewModel.updateEmail(email) },
                        label = "E-Mail",
                        placeholder = "+62 1234 5678",
                        keyboardType = KeyboardType.Email,
                        trailingIcon = Icons.Default.Email
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.instance,
                        onValueChange = { instance -> viewModel.updateInstance(instance) },
                        label = "Instance",
                        placeholder = "university",
                        trailingIcon = Icons.Default.School
                    )
                    StudyProgramDashboardAdminRadioButtonDemo(
                        insertStudyProgram = { viewModel.isStudyProgramDialogOpen() },
                        viewModel = viewModel
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        TextFieldLocationLoginDemo(
                            modifier = Modifier.weight(0.5f),
                            value = viewModel.city,
                            onValueChange = { city -> viewModel.updateCity(city) },
                            label = "City",
                            placeholder = "depok"
                        )
                        TextFieldLocationLoginDemo(
                            modifier = Modifier.weight(0.5f),
                            value = viewModel.province,
                            onValueChange = { province -> viewModel.updateProvince(province) },
                            label = "Province",
                            placeholder = "banten"
                        )
                    }
                    TextFieldDashboardAdminDemo(
                        value = viewModel.description,
                        onValueChange = { description -> viewModel.updateDescription(description) },
                        label = "Description",
                        placeholder = "Lorem ipsum",
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.requirement,
                        onValueChange = { requirement -> viewModel.updateRequirement(requirement) },
                        label = "Requirement",
                        placeholder = "1. Lorem Ipsum",
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.termsCondition,
                        onValueChange = { termsCondition ->
                            viewModel.updateTermsCondition(
                                termsCondition
                            )
                        },
                        label = "Terms & Condition",
                        placeholder = "1. Lorem Ipsum",
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.registration,
                        onValueChange = { registration -> viewModel.updateRegistration(registration) },
                        label = "Registration fee",
                        placeholder = "123.000",
                        prefix = "Rp.",
                        keyboardType = KeyboardType.Number,
                        singleLine = true,
                        trailingIcon = Icons.Default.PriceChange
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.visit,
                        onValueChange = { visit -> viewModel.updateVisit(visit) },
                        label = "Visit fee",
                        placeholder = "123.000",
                        prefix = "Rp.",
                        keyboardType = KeyboardType.Number,
                        singleLine = true,
                        trailingIcon = Icons.Default.PriceChange
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.teleconsultation,
                        onValueChange = { teleconsultation ->
                            viewModel.updateteleconsultation(
                                teleconsultation
                            )
                        },
                        label = "Teleconsultation fee",
                        placeholder = "123.000",
                        prefix = "Rp.",
                        keyboardType = KeyboardType.Number,
                        singleLine = true,
                        trailingIcon = Icons.Default.PriceChange
                    )
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
        viewModel.imageDialog.value -> {
            InsertImageDashboardAdminDialogLogin(
                openDialog = { viewModel.isImageDialogClose() },
            )
        }

        viewModel.studyProgramDialog.value -> {
            InsertStudyProgramDashboardAdminDialogLogin(openDialog = { viewModel.isStudyProgramDialogClose() })
        }

        viewModel.openConfirmationDialog.value -> {
            ConfirmationChangeDialog(viewModel = viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDashboardDialog(
    viewModel: DashboardViewModel
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
                                    "Edit"
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
                    TextFieldDashboardAdminDemo(
                        value = viewModel.schoolName,
                        onValueChange = { school -> viewModel.updateUser(school) },
                        label = "School Name",
                        placeholder = "your name",
                        keyboardType = KeyboardType.Text,
                        trailingIcon = Icons.Default.Person
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.phone,
                        onValueChange = { phone -> viewModel.updatePhone(phone) },
                        label = "Phone",
                        placeholder = "+62 1234 5678",
                        keyboardType = KeyboardType.Phone,
                        trailingIcon = Icons.Default.Phone
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.email,
                        onValueChange = { email -> viewModel.updateEmail(email) },
                        label = "E-Mail",
                        placeholder = "+62 1234 5678",
                        keyboardType = KeyboardType.Email,
                        trailingIcon = Icons.Default.Email
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.instance,
                        onValueChange = { instance -> viewModel.updateInstance(instance) },
                        label = "Instance",
                        placeholder = "university",
                        trailingIcon = Icons.Default.School
                    )
                    StudyProgramDashboardAdminRadioButtonDemo(
                        insertStudyProgram = { viewModel.isStudyProgramDialogOpen() },
                        viewModel = viewModel
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        TextFieldLocationLoginDemo(
                            modifier = Modifier.weight(0.5f),
                            value = viewModel.city,
                            onValueChange = { city -> viewModel.updateCity(city) },
                            label = "City",
                            placeholder = "depok"
                        )
                        TextFieldLocationLoginDemo(
                            modifier = Modifier.weight(0.5f),
                            value = viewModel.province,
                            onValueChange = { province -> viewModel.updateProvince(province) },
                            label = "Province",
                            placeholder = "banten"
                        )
                    }
                    TextFieldDashboardAdminDemo(
                        value = viewModel.description,
                        onValueChange = { description -> viewModel.updateDescription(description) },
                        label = "Description",
                        placeholder = "Lorem ipsum",
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.requirement,
                        onValueChange = { requirement -> viewModel.updateRequirement(requirement) },
                        label = "Requirement",
                        placeholder = "1. Lorem Ipsum",
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.termsCondition,
                        onValueChange = { termsCondition ->
                            viewModel.updateTermsCondition(
                                termsCondition
                            )
                        },
                        label = "Terms & Condition",
                        placeholder = "1. Lorem Ipsum",
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.registration,
                        onValueChange = { registration -> viewModel.updateRegistration(registration) },
                        label = "Registration fee",
                        placeholder = "123.000",
                        prefix = "Rp.",
                        keyboardType = KeyboardType.Number,
                        singleLine = true,
                        trailingIcon = Icons.Default.PriceChange
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.visit,
                        onValueChange = { visit -> viewModel.updateVisit(visit) },
                        label = "Visit fee",
                        placeholder = "123.000",
                        prefix = "Rp.",
                        keyboardType = KeyboardType.Number,
                        singleLine = true,
                        trailingIcon = Icons.Default.PriceChange
                    )
                    TextFieldDashboardAdminDemo(
                        value = viewModel.teleconsultation,
                        onValueChange = { teleconsultation ->
                            viewModel.updateteleconsultation(
                                teleconsultation
                            )
                        },
                        label = "Teleconsultation fee",
                        placeholder = "123.000",
                        prefix = "Rp.",
                        keyboardType = KeyboardType.Number,
                        singleLine = true,
                        trailingIcon = Icons.Default.PriceChange
                    )
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
        viewModel.imageDialog.value -> {
            InsertImageDashboardAdminDialogLogin(
                openDialog = { viewModel.isImageDialogClose() },
            )
        }

        viewModel.studyProgramDialog.value -> {
            InsertStudyProgramDashboardAdminDialogLogin(openDialog = { viewModel.isStudyProgramDialogClose() })
        }

        viewModel.openConfirmationDialog.value -> {
            ConfirmationChangeDialog(viewModel = viewModel)
        }
    }
}



@Composable
fun InsertImageDashboardAdminDialogLogin(
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
fun InsertStudyProgramDashboardAdminDialogLogin(
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

@Composable
fun ConfirmationChangeDialog(
    viewModel: DashboardViewModel
) {
    AlertDialog(
        icon = {
            Icon(Icons.Default.PriorityHigh, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Discard Changes?")
        },
        text = {
            Text(text = "Adding subject has been unsaved. Are you want discard changes?")
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
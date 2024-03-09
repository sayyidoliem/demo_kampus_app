package com.example.kampusappdemo.module.guest.feature.login.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo

@Composable
fun StudyProgramRadioButtonDemo(insertStudyProgram: () -> Unit, viewModel: LoginViewModel) {

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(viewModel.studyProgramOptions[0]) }
    Column {
        TextSubHeadlineDemo(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Study Program"
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            viewModel.studyProgramOptions.forEach { text ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (text == selectedOption),
                        modifier = Modifier.padding(4.dp),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    if (text == selectedOption) {
                        Text(text = text, color = MaterialTheme.colorScheme.primary)
                    } else {
                        Text(
                            modifier = Modifier.clickable { onOptionSelected(text) },
                            text = text
                        )
                    }
                    if (text == "Specific") {
                        IconButton(onClick = { insertStudyProgram() }) {
                            Icon(
                                imageVector = Icons.Default.OpenInNew,
                                contentDescription = ""
                            )
                        }
                    }
                }

            }
        }
    }

}
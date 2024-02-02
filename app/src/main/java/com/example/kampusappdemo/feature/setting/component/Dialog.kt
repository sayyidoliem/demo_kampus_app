package com.example.kampusappdemo.feature.setting.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.kotpref.SettingPreferences

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
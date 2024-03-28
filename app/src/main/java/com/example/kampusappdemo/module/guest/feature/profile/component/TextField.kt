package com.example.kampusappdemo.module.guest.feature.profile.component

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldEditProfileDemo(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    singleLine: Boolean? = null,
    keyboardType: KeyboardType? = null,
    visualTransformation: VisualTransformation? = null,
    trailingIcon: ImageVector? = null
) {
    val isValid = remember { mutableStateOf(true) }

    var isError by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = value,
            visualTransformation = visualTransformation ?: VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType ?: KeyboardType.Text,
                imeAction = ImeAction.Done,
                autoCorrect = true
            ),
            isError = isError,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            label = { Text(text = label) },
            trailingIcon = {
                when {
                    !isValid.value -> {
                        Icon(
                            imageVector = Icons.Default.Error,
                            tint = MaterialTheme.colorScheme.error,
                            contentDescription = "Invalid input"
                        )
                    }

                    else -> {
                        (trailingIcon ?: trailingIcon)?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = ""
                            )
                        }
                    }
                }
            },
            singleLine = singleLine ?: true,
            keyboardActions = KeyboardActions(onDone = {
                isValid.value = when (keyboardType) {
                    KeyboardType.Email -> Patterns.EMAIL_ADDRESS.matcher(value).matches()
                    KeyboardType.Phone -> Patterns.PHONE.matcher(value).matches()
                    else -> true
                }
                keyboardController?.hide()
            }),
            supportingText = {
                when {
                    !isValid.value -> {
                        Text(
                            text = "Invalid input",
                            color = MaterialTheme.colorScheme.error,
                        )
                        isError = !isError
                    }

                    else -> !isError
                }
            }
        )
    }
}
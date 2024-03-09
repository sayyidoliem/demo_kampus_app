package com.example.kampusappdemo.module.guest.feature.login.component

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldLoginDemo(
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
        TextSubHeadlineDemo(modifier = Modifier.padding(horizontal = 16.dp), text = label)
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = value,
            visualTransformation = visualTransformation ?: VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType ?: KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            isError = isError,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
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

@Composable
fun TextFieldPasswordLoginDemo(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType? = null,
) {
    val (passwordVisibility, setPasswordVisibility) = remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        TextSubHeadlineDemo(modifier = Modifier.padding(horizontal = 16.dp), text = label)
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = value,
            onValueChange = { input -> onValueChange(input) },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType ?: KeyboardType.Text),
            placeholder = { Text(text = placeholder) },
            trailingIcon = {
                IconButton(onClick = { setPasswordVisibility(!passwordVisibility) }) {
                    Icon(
                        imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = ""
                    )
                }
            },
            supportingText = { },
            singleLine = true
        )
    }
}

@Composable
fun TextFieldLocationLoginDemo(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    singleLine: Boolean? = null,
    keyboardType: KeyboardType? = null,
    visualTransformation: VisualTransformation? = null,
) {
    Column(modifier = modifier) {
        TextSubHeadlineDemo(modifier = Modifier.padding(horizontal = 16.dp), text = label)
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = value,
            visualTransformation = visualTransformation ?: VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType ?: KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            trailingIcon = {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
            },
            singleLine = singleLine ?: true,
            supportingText = { }
        )
    }
}


@Composable
fun TextFieldInsertImage(viewModel: LoginViewModel) {
    TextSubHeadlineDemo(modifier = Modifier.padding(horizontal = 16.dp), text = "Logo")
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = "logo.png",
        onValueChange = {},
        readOnly = true,
        leadingIcon = {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = ""
            )
        },
        trailingIcon = {
            IconButton(onClick = { viewModel.isImageDialogOpen() }) {
                Icon(
                    imageVector = Icons.Default.OpenInNew,
                    contentDescription = ""
                )
            }
        },
        supportingText = { }
    )
}
package com.example.kampusappdemo.module.guest.feature.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun BottomBarSignInLoginDemo(openDialog : () -> Unit){
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            textAlign = TextAlign.Center
        ),
        text = buildAnnotatedString {
            append("Don't have an account? ")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Sign Up")
            }
        },
        onClick = {
            openDialog()
        })
}

@Composable
fun BottomBarSignUpLoginDemo(navigate : () -> Unit){
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            textAlign = TextAlign.Center
        ),
        text = buildAnnotatedString {
            append("Already have an account? ")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Login")
            }
        },
        onClick = {
            navigate()
        })
}
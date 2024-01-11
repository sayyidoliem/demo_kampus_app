package com.example.kampusappdemo.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight



@Composable
fun TextTitleDemo(
    modifier: Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineMedium
    )
}
@Composable
fun TextHeadlineDemo(
    modifier: Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.SemiBold,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun TextSubHeadlineDemo(
    modifier: Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.SemiBold,
        style = MaterialTheme.typography.bodyLarge
    )
}
@Composable
fun TextParagraphDemo(
    modifier: Modifier,
    text: String
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge
    )
}
package com.example.kampusappdemo.module.user.feature.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBarDetailDemo(
    onClickFAQ: () -> Unit,
    onClickRegister: () -> Unit,
    registerEnabled: Boolean
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentPadding = PaddingValues(4.dp)
    ) {
        OutlinedButton(
            modifier = Modifier.weight(0.5F),
            onClick = { onClickFAQ() }) {
            Text(text = "FAQ")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            enabled = registerEnabled,
            modifier = Modifier.weight(0.5F),
            onClick = {
                onClickRegister()
            }) {
            Text(text = "Register Now")
        }
    }
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        OutlinedButton(
//            modifier = Modifier.weight(0.5F),
//            onClick = { onClickFAQ() }) {
//            Text(text = "FAQ")
//        }
//        Spacer(modifier = Modifier.padding(8.dp))
//        Button(
//            enabled = registerEnabled,
//            modifier = Modifier.weight(0.5F),
//            onClick = {
//                onClickRegister()
//            }) {
//            Text(text = "Register Now")
//        }
//    }
}
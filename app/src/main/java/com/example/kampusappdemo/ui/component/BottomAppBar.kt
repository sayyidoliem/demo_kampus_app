package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun BottomAppBarDemo(
    icon : ImageVector
) {

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFFF0E7BC),
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Add your icons here
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = icon, contentDescription = "")
                }
            }
        }
    )
}

@Composable
fun BottomAppBarDetailDemo(
    onClickFAQ: () -> Unit,
    onClickRegister: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(
            modifier = Modifier.weight(0.5F),
            onClick = { onClickFAQ() }) {
            Text(text = "FAQ")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            modifier = Modifier.weight(0.5F),
            onClick = {
                onClickRegister()
            }) {
            Text(text = "Register Now")
        }
    }
}

@Composable
fun BottomAppBarPaymentDemo() {
    BottomAppBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Total Price : 2003k")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Order")
            }
        }
    }
}

@Composable
fun BottomAppBarProfileDemo(
    onClick : () -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        onClick = { onClick() }) {
        Text(text = "Edit Profile")
    }
}
package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun BottomAppBarDemo(
    icon: ImageVector
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
    onClickRegister: () -> Unit,
    registerEnabled : Boolean
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
            enabled = registerEnabled,
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
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        onClick = { onClick() }) {
        Text(text = "Edit Profile")
    }
}

@Composable
fun BottomAppBarSettingDemo(
    version: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Kampus Demo App")
        Text(text = "Version $version")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarChatDemo() {
    var searchBar by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        ChatInputDemo(
            modifier = Modifier.weight(0.8F),
            p = "Let's Chat",
            i = searchBar,
            isShowSearchBar = { !searchBar })
        Spacer(modifier = Modifier.padding(4.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            shape = CircleShape
        ) {
            IconButton(
                modifier = Modifier.padding(5.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "")
            }
        }
    }
}
package com.example.kampusappdemo.module.admin.feature.chat.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarChatAdminDemo(
    navigate: () -> Unit,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "User") },
        navigationIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navigate() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
                Image(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }


        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "")
            }
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarListChatAdminDemo() {
    CenterAlignedTopAppBar(title = { Text(text = "Chat") })
}
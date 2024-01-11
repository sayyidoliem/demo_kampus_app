package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.demomarketapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHomeDemo() {
    TopAppBar(
        title = {
            Text(
                text = "Hello \nusername".uppercase(),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = ""
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearchDemo(
    searchIconState: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Name Product") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { searchIconState() }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDetailDemo() {
    TopAppBar(
        title = { // TODO:
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backNavigation")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPaymentDemo() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Payment") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarProfileDemo(
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Profile") },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSettingDemo(
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Settings") },
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarChatDemo(
    navigate: () -> Unit,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Chat") },
        navigationIcon = {
            IconButton(onClick = { navigate() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSavedDemo() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Saved") },

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarBookingDemo() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Booking") },
    )
}

package com.example.demomarketapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.demomarketapp.navigation.BottomNavItem


@Composable
fun BottomAppBarDemo() {
    val selected = remember { mutableStateOf(BottomNavItem.Home) }
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
                    Icons.Default.Home
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icons.Default.Search
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icons.Default.AccountCircle
                }
            }
        }
    )
}



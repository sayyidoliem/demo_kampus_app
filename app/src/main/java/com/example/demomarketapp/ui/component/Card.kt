package com.example.demomarketapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R

@Preview
@Composable
fun prev() {
    CardListCartDemo()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardListHomeDemo() {
    Column() {
        ListItem(
            modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
            headlineText = { Text(text = "Judul") },
            overlineText = { Text(text = "Alamat") },
            trailingContent = {
                Button(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Shopping Cart"
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardListCartDemo() {
    ListItem(
        leadingContent = {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = ""
            )
        },
        headlineText = { Text(text = "Nma prodi") },
        supportingText = {
            Column {
                Row {
                    Icon(imageVector = Icons.Default.Circle, contentDescription = "")
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "TEmpat")
                }
                Row {
                    Icon(imageVector = Icons.Default.Circle, contentDescription = "")
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "TEmpat")
                }
                Row {
                    Icon(imageVector = Icons.Default.Circle, contentDescription = "")
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "TEmpat")
                }
            }
        },
        trailingContent = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
            }
        }
    )
}
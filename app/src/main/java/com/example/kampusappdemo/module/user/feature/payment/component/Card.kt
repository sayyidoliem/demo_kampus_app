package com.example.kampusappdemo.module.user.feature.payment.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.demomarketapp.R

@Composable
fun CardPaymentMethodDemo() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .defaultMinSize(minWidth = 120.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Bank",
        )
    }
}
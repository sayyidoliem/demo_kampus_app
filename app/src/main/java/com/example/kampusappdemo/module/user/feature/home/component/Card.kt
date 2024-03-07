package com.example.kampusappdemo.module.user.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kampusappdemo.model.Location

@Composable
fun CardLastSeenHomeDemo(
    nameCampus: String,
    typeCampus: String,
    ratingCampus: Double,
    location: Location,
    image: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(16.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column{
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 200.dp),
                    painter = painterResource(id = image) ,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = typeCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = nameCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                Text(text = ratingCampus.toString())
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "${location.city}, ${location.province}",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}

@Composable
fun CardListHomeDemo(
    nameCampus: String,
    typeCampus: String,
    studyProgram: String,
    ratingCampus: Double,
    location: Location,
    image: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(16.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column {
            Box {
                Image(
                    modifier = Modifier
                        .widthIn(max = 300.dp)
                        .aspectRatio(16f / 9f),
                    painter = painterResource(id = image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = typeCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = nameCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            if (studyProgram.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Program $studyProgram",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                Text(text = ratingCampus.toString())
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "${location.city}, ${location.province}",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}


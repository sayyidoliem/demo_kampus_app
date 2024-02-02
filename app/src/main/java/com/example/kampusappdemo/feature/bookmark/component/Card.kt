package com.example.kampusappdemo.feature.bookmark.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kampusappdemo.model.Location

@Composable
fun CardListBookmarkDemo(
    nameCampus: String,
    typeCampus: String,
    ratingCampus: Double,
    image: String,
    location: Location,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(16.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            Box {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minWidth = 56.dp, minHeight = 56.dp)
                        .heightIn(max = 200.dp),
                    model = image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.TopEnd),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = nameCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = typeCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Row(modifier = Modifier.padding(8.dp)) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "")
                    Text(text = ratingCampus.toString())
                }
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "${location.city}, ${location.province}",
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}
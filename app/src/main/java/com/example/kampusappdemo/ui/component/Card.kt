package com.example.kampusappdemo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.RemoveCircleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
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
import com.example.demomarketapp.R
import com.example.kampusappdemo.model.Location

@Composable
fun CardListHomeDemo(
    nameCampus: String,
    typeCampus: String,
    studyProgram: String,
    ratingCampus: Double,
    location: Location,
    image: String,
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
                        .widthIn(max = 300.dp)
                        .aspectRatio(16f / 9f),
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

@Composable
fun CardLastSeenHomeDemo(
    nameCampus: String,
    typeCampus: String,
    ratingCampus: Double,
    location: Location,
    image: String,
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
fun CardListSearchDemo(
    nameCampus: String,
    studyProgram: String,
    typeCampus: String,
    ratingCampus: Double,
    image: String,
    city: String,
    province: String,
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
                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                if (studyProgram.isEmpty()) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = nameCampus,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                } else {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "$nameCampus | $studyProgram",
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 8.dp),
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
                    text = "$city, $province",
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
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
        headlineContent = { Text(text = "Product Name") },
        supportingContent = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(12.dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Vendor Name")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(12.dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Delivery type")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(12.dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Price")
                }
            }
        },
        trailingContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.AddCircleOutline, contentDescription = "")
                }
                Text(text = "0")
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Outlined.RemoveCircleOutline, contentDescription = "")
                }
            }
        }
    )
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProfileDemo() {
    Card {
        ListItem(
            headlineContent = {
                Text(text = "Name")
            },
            supportingContent = {
                Text(text = "Aksa Akakaak")
            }
        )
        Divider()
        ListItem(
            headlineContent = {
                Text(text = "Phone Number")
            },
            supportingContent = {
                Text(text = "+123 - 4567 - 8910")
            }
        )
        Divider()
        ListItem(
            headlineContent = {
                Text(text = "E - Mail")
            },
            supportingContent = {
                Text(text = "Blablabla@gmail.com")
            }
        )
    }
}

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
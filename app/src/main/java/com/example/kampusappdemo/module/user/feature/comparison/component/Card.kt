package com.example.kampusappdemo.module.user.feature.comparison.component

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardListComparisonDemo(
    nameCampus: String,
    studyProgram: String,
    typeCampus: String,
    ratingCampus: Double,
    image: Int,
    city: String,
    province: String,
    visit : Double,
    teleConsultation : Double,
    register : Double,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minWidth = 56.dp, minHeight = 56.dp)
                .heightIn(max = 200.dp)
                .border(
                    BorderStroke(4.dp, Color.Gray),
                    RectangleShape
                )
                .clickable { onClick() },
            painter = painterResource(id = image),
//                    placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            if (studyProgram.isEmpty()) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = nameCampus,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            } else {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "$nameCampus | $studyProgram",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Row(modifier = Modifier.padding(vertical = 12.dp),) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                Text(text = ratingCampus.toString())
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "level",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall,
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = typeCampus,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "address",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall,
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = "$city, $province",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "registration fee",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall,
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rp. ${register}00",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "register")
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "teleconsultation fee",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall,
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rp. ${teleConsultation}00",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "consult")
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "visit fee",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall,
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rp. ${visit}00",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "visit")
                }
            }
        }
    }
}
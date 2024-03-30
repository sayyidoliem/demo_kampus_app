package com.example.kampusappdemo.module.guest.feature.login.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.module.guest.feature.login.component.TopBarLoginDemo
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel
import com.example.kampusappdemo.ui.component.TextHeadlineDemo

@Composable
fun ChangeTypeUserLogin(
    navigateUp: () -> Unit,
    changeStudent: () -> Unit,
    changeInstance: () -> Unit,
    viewModel: LoginViewModel
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = viewModel.list

    Scaffold(topBar = {
        TopBarLoginDemo(navigate = { navigateUp() })
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextHeadlineDemo(modifier = Modifier, text = "What role you want?")
            Spacer(modifier = Modifier.padding(32.dp))
            TabRow(selectedTabIndex = selectedIndex,
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.clip(RoundedCornerShape(50)),
                indicator = { _: List<TabPosition> ->
                    Box {}
                }
            ) {
                list.forEachIndexed { index, text ->
                    val selected = selectedIndex == index
                    Tab(
                        modifier = when {
                            selected -> Modifier
                                .clip(RoundedCornerShape(50))
                                .background(MaterialTheme.colorScheme.onPrimary)

                            else -> Modifier
                                .clip(RoundedCornerShape(100))
                                .background(MaterialTheme.colorScheme.surface)
                        },
                        selected = selected,
                        onClick = { selectedIndex = index },
                        text = {
                            Text(
                                text = text,
                                color =
                                if (selected) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurface
                                }
                            )
                        })
                }
            }
            Spacer(modifier = Modifier.padding(32.dp))
            when (selectedIndex) {
                0 -> {
                    ElevatedCard(
                        modifier = Modifier
                            .aspectRatio(0.5f / 0.5f)
                            .padding(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            TextHeadlineDemo(
                                modifier = Modifier.align(Alignment.TopCenter),
                                text = "Student"
                            )
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "You're student"
                            )
                            Button(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter),
                                onClick = { changeStudent() }) {
                                Text(text = "Sign Up")
                            }
                        }
                    }
                }

                1 -> {
                    ElevatedCard(
                        modifier = Modifier
                            .aspectRatio(0.5f / 0.5f)
                            .padding(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            TextHeadlineDemo(
                                modifier = Modifier.align(Alignment.TopCenter),
                                text = "Instance/College"
                            )
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "You're contributor",
                                textAlign = TextAlign.Center
                            )
                            Button(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter),
                                onClick = { changeInstance() }) {
                                Text(text = "Sign Up")
                            }
                        }
                    }
                }
            }
        }
    }
}
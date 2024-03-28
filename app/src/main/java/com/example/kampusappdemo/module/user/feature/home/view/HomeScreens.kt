package com.example.kampusappdemo.module.user.feature.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.data.datastore.UserData
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.module.user.feature.home.component.CardLastSeenHomeDemo
import com.example.kampusappdemo.module.user.feature.home.component.CardListHomeDemo
import com.example.kampusappdemo.module.user.feature.home.component.SignInHomeDialog
import com.example.kampusappdemo.module.user.feature.home.component.TopAppBarHomeDemo
import com.example.kampusappdemo.module.user.feature.home.viewmodel.HomeViewModel
import com.example.kampusappdemo.ui.component.TextHeadlineDemo
import com.example.kampusappdemo.ui.component.TextSubHeadlineDemo

@Composable
fun HomeScreens(
    viewModel: HomeViewModel,
    navigate: (index: Int?) -> Unit,
    navigateToSignIn: () -> Unit,
    actionTopBar: () -> Unit
) {
    val context = LocalContext.current

    val list = viewModel.dataList(context)

    val listLastSeen = viewModel.filterDataByLastSeen(context)

    val dataStore = UserData(context)

    val userName = dataStore.getUserName.collectAsState(initial = "")
    Scaffold(
        topBar = {
            TopAppBarHomeDemo(
                name = userName.value!!,
                onClick = {
                    if (SettingPreferences.typeUser == SettingPreferences.GUEST) {
                        viewModel.showDialog()
                    } else {
                        actionTopBar()
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            TextHeadlineDemo(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Last seen with you"
            )
            listLastSeen.forEach { educationData ->
                CardLastSeenHomeDemo(
                    nameCampus = educationData.name,
                    typeCampus = educationData.instance,
                    ratingCampus = educationData.rating,
                    location = educationData.location,
                    image = ImageDummy[8].image
                ) {
                    navigate(educationData.id)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    TextSubHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Let's See Last Trending University"
                    )
                    TextHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Trending University"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                }
            }
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(list) { educationData ->
                    CardListHomeDemo(
                        nameCampus = educationData.name,
                        typeCampus = educationData.instance,
                        studyProgram = educationData.studyProgram,
                        ratingCampus = educationData.rating,
                        location = educationData.location,
                        image = ImageDummy[educationData.id].image
                    ) {
                        navigate(educationData.id)
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    TextSubHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "All Exlusive For You"
                    )
                    TextHeadlineDemo(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Recommended University"
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                }
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(list) { educationData ->
                    CardListHomeDemo(
                        nameCampus = educationData.name,
                        typeCampus = educationData.instance,
                        studyProgram = educationData.studyProgram,
                        ratingCampus = educationData.rating,
                        location = educationData.location,
                        image = ImageDummy[educationData.id].image
                    ) {
                        navigate(educationData.id)
                    }
                }
            }
        }
    }
    when {
        viewModel.openEditDialog.value -> {
            SignInHomeDialog(navigate = { navigateToSignIn() }, viewModel = viewModel)
        }
    }
}
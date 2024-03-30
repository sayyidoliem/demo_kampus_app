package com.example.kampusappdemo.module.user.feature.comparison.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.demomarketapp.R
import com.example.kampusappdemo.data.local.database.ImageDummy
import com.example.kampusappdemo.model.EducationData
import com.example.kampusappdemo.module.user.feature.comparison.component.AddComparisonDialogDemo
import com.example.kampusappdemo.module.user.feature.comparison.component.CardListComparisonDemo
import com.example.kampusappdemo.module.user.feature.comparison.component.DeleteComparisonDialogDemo
import com.example.kampusappdemo.module.user.feature.comparison.component.DetailComparisonDialogDemo
import com.example.kampusappdemo.module.user.feature.comparison.component.FABComparisonScreensDemo
import com.example.kampusappdemo.module.user.feature.comparison.component.TopBarComparisonScreensDemo
import com.example.kampusappdemo.module.user.feature.comparison.viewmodel.ComparisonViewModel
import com.example.kampusappdemo.ui.component.TextParagraphDemo
import kotlinx.coroutines.launch

@Composable
fun ComparisonScreens(index: Int, navigateUp: () -> Unit, viewModel: ComparisonViewModel) {

    val context = LocalContext.current

    if (viewModel.comparisonList.isEmpty()) {
        viewModel.addComparison(index)
    }

    val finalDataList = viewModel.dataList(context)

    Scaffold(
        topBar = {
            TopBarComparisonScreensDemo(
                navigate = { navigateUp() },
                viewModel = viewModel
            )
        },
        floatingActionButton = {
            if (viewModel.comparisonList.size <= 3) {
                FABComparisonScreensDemo(viewModel = viewModel)
            }
        }
    ) {
        LazyVerticalGrid(modifier = Modifier.padding(it), columns = GridCells.Fixed(2)) {
            items(viewModel.comparisonList.size) { index ->
                viewModel.filterDataByIndex(context, viewModel.comparisonList[index])
                    .forEach { educationData ->
                        CardListComparisonDemo(
                            nameCampus = educationData.name,
                            studyProgram = educationData.studyProgram,
                            typeCampus = educationData.instance,
                            ratingCampus = educationData.rating,
                            image = ImageDummy[educationData.id].image,
                            city = educationData.location.city,
                            province = educationData.location.province,
                            visit = educationData.visit,
                            teleConsultation = educationData.teleConsultation,
                            register = educationData.register,
                            onClick = { viewModel.showDetailDialog() },
                        )
                    }
            }
        }
    }
    when {
        viewModel.openAddDialog.value -> {
            AddComparisonDialogDemo(context = context, viewModel = viewModel)
        }

        viewModel.openDeleteDialog.value -> {
            DeleteComparisonDialogDemo(viewModel = viewModel)
        }

        viewModel.openDetailDialog.value -> {
            finalDataList.forEach { educationData ->
                DetailComparisonDialogDemo(
                    name = educationData.name,
                    textDescription = educationData.description,
                    textRequirement = educationData.requirement,
                    textTermsCondition = educationData.termsCondition,
                    viewModel = viewModel
                )
            }
        }
    }
}
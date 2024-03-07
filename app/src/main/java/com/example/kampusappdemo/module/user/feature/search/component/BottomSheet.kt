package com.example.kampusappdemo.module.user.feature.search.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.model.EducationData
import com.example.kampusappdemo.module.user.feature.search.viewmodel.SearchViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheetSearchDemo(
    list: List<EducationData>,
    viewModel: SearchViewModel
) {
    val sheetState = rememberModalBottomSheetState()

    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            viewModel.onToogleFilter()
        },
        sheetState = sheetState
    ) {
        FilterList(title = "City", list = list.map { it.location.city })
        FilterList(title = "Study Program", list = list.map { it.studyProgram })
        FilterList(title = "Instance", list = list.map { it.instance })
        Button(
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp),
            onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        viewModel.onToogleFilter()
                    }
                }
            }) {
            Text("Save")
        }
    }
}

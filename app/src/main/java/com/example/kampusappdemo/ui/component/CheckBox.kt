package com.example.kampusappdemo.ui.component

import android.widget.CheckBox
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable

@Composable
fun CheckBoxDemo(
    checked : Boolean,
    onCheckedChange : () -> Unit
){
    Checkbox(
        checked = checked,
        onCheckedChange = { !checked }
    )
}
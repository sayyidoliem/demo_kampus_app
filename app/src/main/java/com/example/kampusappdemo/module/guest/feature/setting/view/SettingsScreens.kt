package com.example.kampusappdemo.module.guest.feature.setting.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demomarketapp.BuildConfig
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.guest.feature.setting.component.BottomAppBarSettingDemo
import com.example.kampusappdemo.module.guest.feature.setting.component.ChangeTranslateDialogDemo
import com.example.kampusappdemo.module.guest.feature.setting.component.ListItemDropdownDemo
import com.example.kampusappdemo.module.guest.feature.setting.component.ListItemSwitchSettingsDemo
import com.example.kampusappdemo.module.guest.feature.setting.component.TopAppBarSettingDemo
import com.example.kampusappdemo.module.guest.feature.setting.viewmodel.SettingsViewmodel
import com.example.kampusappdemo.utils.GlobalState

@Composable
fun SettingsScreens(
    modifier: Modifier, navigate: () -> Unit,
    viewmodel: SettingsViewmodel
) {
    val versionApp = BuildConfig.VERSION_NAME
    Scaffold(modifier = modifier,
        topBar = {
            TopAppBarSettingDemo(onClick = { navigate() })
        },
        bottomBar = {
            BottomAppBarSettingDemo(version = versionApp)
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            ListItemSwitchSettingsDemo(
                icon = Icons.Default.DarkMode,
                headLineText = "Dark Mode",
                supportText = "Change theme app to dark mode",
                isSwitchClicked = GlobalState.isDarkMode,
                onSwitchClick = { isChecked ->
                    GlobalState.isDarkMode = isChecked
                    SettingPreferences.isDarkMode = isChecked
                }
            )
            ListItemDropdownDemo(
                icon = Icons.Default.Language,
                headLineText = "Change Language",
                supportText = "Change language app to other language",
                onClick = {
                    viewmodel.isTranslateDialogOpen()
                },
            )
        }
    }
    when {
        viewmodel.translate.value -> {
            ChangeTranslateDialogDemo(openDialog = {
                viewmodel.isTranslateDialogClose()
            })
        }
    }
}
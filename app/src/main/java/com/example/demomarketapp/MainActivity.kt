package com.example.demomarketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.demomarketapp.navigation.BottomNavItem
import com.example.demomarketapp.ui.theme.DemoMarketAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoMarketAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val items = listOf(
                        BottomNavItem.Home,
                        BottomNavItem.Search,
                        // Tambahkan item lainnya di sini
                    )
                    /*
                    val navController = rememberNavController()
                    val currentRoute = currentRoute(navController)
                    Scaffold(
                        bottomBar = {
                            BottomNavigation {
                                items.forEach { item ->
                                    BottomNavigationItem(
                                        icon = { Icon(item.icon, contentDescription = item.label) },
                                        label = { Text(item.label) },
                                        selected = currentRoute == item.route,
                                        onClick = {
                                            navController.navigate(item.route) {
                                                launchSingleTop = true
                                                restoreState = true
                                                popUpTo(findStartDestination(navController.graph).id) {
                                                    saveState = true
                                                }
                                            }
                                        }
                                    )
                                }
                            }
                        },
                        content = { innerPadding ->
                            NavHost(navController, startDestination = BottomNavItem.Home.route, Modifier.padding(innerPadding)) {
                                composable(BottomNavItem.Home.route) { /* Tampilkan konten untuk Home di sini */ }
                                composable(BottomNavItem.Search.route) { /* Tampilkan konten untuk Search di sini */ }
                                // Tambahkan composable untuk item lainnya di sini
                            }
                        }
                    )
                     */
                    /*
                            bottomBar = {
                                if (bottomNavItemList.any {
                                        it.route == currentRoute
                                    }
                                ) NavigationBar(
                                    modifier = Modifier.clip(
                                        RoundedCornerShape(
                                            topStart = 30.dp,
                                            topEnd = 30.dp
                                        )
                                    )
                                ) {
                                    bottomNavItemList.map { item: BottomNavItem ->
                                        NavigationBarItem(
                                            selected = currentRoute == item.route,//untuk membandingkan index
                                            onClick = {
                                                currentRoute = item.route
                                                navController.navigate(item.route) {
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState =
                                                            true //buat menyimpan state mutable di setiap screen
                                                    }
                                                    restoreState = true
                                                    launchSingleTop =
                                                        true//buat klo back, langsung keluar app(bukan ke home)
                                                }
                                            },
                                            icon = {
                                                Icon(
                                                    imageVector = item.iconBottom,
                                                    contentDescription = item.label
                                                )
                                            },
                                            label = { Text(text = item.label) },
                                        )
                                    }
                                }
                            },
                             */
                }
            }
        }
    }
}


@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry = navController.currentBackStackEntry
    return navBackStackEntry?.destination?.route
}

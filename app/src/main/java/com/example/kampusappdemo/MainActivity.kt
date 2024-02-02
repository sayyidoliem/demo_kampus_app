package com.example.kampusappdemo

import PaymentScreens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kampusappdemo.navigation.BottomNavigationDemo
import com.example.kampusappdemo.navigation.Screens
import com.example.kampusappdemo.feature.detail.view.DetailScreens
import com.example.kampusappdemo.feature.home.view.HomeScreens
import com.example.kampusappdemo.feature.profile.view.ProfileScreens
import com.example.kampusappdemo.feature.search.view.SearchScreens
import com.example.kampusappdemo.feature.setting.view.SettingsScreens
import com.example.kampusappdemo.ui.theme.DemoMarketAppTheme
import com.example.kampusappdemo.feature.booking.view.BookingScreens
import com.example.kampusappdemo.feature.bookmark.view.BookmarkScreens
import com.example.kampusappdemo.feature.bookmark.viewmodel.BookmarkViewModel
import com.example.kampusappdemo.feature.chat.view.ChatScreens
import com.example.kampusappdemo.feature.detail.viewmodel.DetailViewmodel
import com.example.kampusappdemo.feature.home.viewmodel.HomeViewModel
import com.example.kampusappdemo.feature.payment.viewmodel.PaymentViewModel
import com.example.kampusappdemo.feature.profile.viewmodel.ProfileViewModel
import com.example.kampusappdemo.feature.search.viewmodel.SearchViewModel
import com.example.kampusappdemo.feature.setting.viewmodel.SettingsViewmodel
import com.example.kampusappdemo.utils.GlobalState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoMarketAppTheme(
                darkTheme = GlobalState.isDarkMode
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    val currentRoute: String? = navBackStackEntry?.destination?.route
                    Scaffold(
                        bottomBar = {
                            @Suppress("UNUSED_EXPRESSION")
                            when (currentRoute) {
                                Screens.Detail.route -> null
                                Screens.Setting.route -> null
                                Screens.Chat.route -> null
                                Screens.Payment.route -> null
                                else -> NavigationBar {
                                    //getting the list of bottom navigation items for our data class
                                    BottomNavigationDemo().BottomNavItemDemo()
                                        .forEachIndexed { index, navigationItem ->
                                            //iterating all items with their respective indexes
                                            NavigationBarItem(
                                                selected = navigationItem.route == currentDestination?.route,
                                                label = {
                                                    Text(navigationItem.label)
                                                },
                                                icon = {
                                                    Icon(
                                                        navigationItem.icon,
                                                        contentDescription = navigationItem.label
                                                    )
                                                },
                                                onClick = {
                                                    navController.navigate(navigationItem.route) {
                                                        popUpTo(navController.graph.findStartDestination().id) {
                                                            saveState = true
                                                        }
                                                        launchSingleTop = true
                                                        restoreState = true
                                                    }
                                                }
                                            )
                                        }
                                }
                            }
                        }
                    ) {
                        NavHost(
                            modifier = Modifier.padding(it),
                            navController = navController,
                            startDestination = Screens.Search.route
                        ) {
                            composable(Screens.Home.route) {
                                HomeScreens(
                                    viewModel = HomeViewModel(),
                                    navigate = { index ->
                                        navController.navigate(
                                            Screens.Detail.createRoute(
                                                index = index,
                                            )
                                        )
                                    },
                                    actionTopBar = { navController.navigate(Screens.Chat.route) }
                                )
                            }
                            composable(Screens.Search.route) {
                                SearchScreens(
                                    modifier = Modifier.fillMaxSize(),
                                    navigate = { index->
                                        navController.navigate(
                                            Screens.Detail.createRoute(
                                                index,
                                            )
                                        )
                                    },
                                    viewModel = SearchViewModel()
                                )
                            }
                            composable(
                                Screens.Detail.route,
                                arguments = listOf(
                                    navArgument("index"){
                                      type = NavType.IntType
                                      defaultValue = 1
                                    },
                                ),
                            ) {
                                val index = it.arguments!!.getInt("index",1)
                                DetailScreens(
                                    modifier = Modifier,
                                    navigateUp = { navController.navigateUp() },
                                    navigate = { navController.navigate(Screens.Chat.route) },
                                    index = index,
                                    viewModel = DetailViewmodel()
                                )
                            }
                            composable(Screens.Chat.route) {
                                ChatScreens(
                                    navigateUp = { navController.navigateUp() }
                                )
                            }
                            composable(Screens.Booking.route) {
                                BookingScreens(
                                    navigate = { name, city, image, type ->
                                        navController.navigate(
                                            Screens.Payment.createRoute(
                                                name, city, image, type
                                            )
                                        )
                                    },
                                )
                            }
                            composable(
                                Screens.Payment.route,
                                arguments = listOf(
                                    navArgument("name") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument("city") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument("image") {
                                        type = NavType.IntType
                                        defaultValue = 0
                                    },
                                    navArgument("type") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                ),
                            ) {
                                val name = it.arguments!!.getString("name", "")
                                val city = it.arguments!!.getString("city", "")
                                val image = it.arguments!!.getInt("image", 0)
                                val type = it.arguments!!.getString("type", "")
                                PaymentScreens(
                                    modifier = Modifier,
                                    nameUniversity = name,
                                    nameCity = city,
                                    imageUniversity = image,
                                    typeUniversity = type,
                                    viewModel = PaymentViewModel(),
                                    navigateUp = { navController.navigateUp() }
                                )
                            }
                            composable(Screens.Bookmark.route) {
                                BookmarkScreens(
                                    modifier = Modifier,
                                    viewModel = BookmarkViewModel(),
                                    navigate = { index ->
                                        navController.navigate(
                                            Screens.Detail.createRoute(
                                                index = index,
                                            )
                                        )
                                    },
                                )
                            }
                            composable(Screens.Profile.route) {
                                ProfileScreens(
                                    modifier = Modifier,
                                    viewModel = ProfileViewModel(),
                                    navigate = { navController.navigate(Screens.Setting.route) })
                            }
                            composable(Screens.Setting.route) {
                                SettingsScreens(
                                    modifier = Modifier,
                                    navigate = { navController.navigateUp() },
                                    viewmodel = SettingsViewmodel()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
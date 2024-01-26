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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kampusappdemo.navigation.BottomNavigationDemo
import com.example.kampusappdemo.navigation.Screens
import com.example.kampusappdemo.ui.view.detail.DetailScreens
import com.example.kampusappdemo.ui.view.home.HomeScreens
import com.example.kampusappdemo.ui.view.profile.ProfileScreens
import com.example.kampusappdemo.ui.view.search.SearchScreens
import com.example.kampusappdemo.ui.view.setting.SettingsScreens
import com.example.kampusappdemo.ui.theme.DemoMarketAppTheme
import com.example.kampusappdemo.ui.view.booking.BookingScreens
import com.example.kampusappdemo.ui.view.bookmark.BookmarkScreens
import com.example.kampusappdemo.ui.view.bookmark.BookmarkViewModel
import com.example.kampusappdemo.ui.view.chat.ChatScreens
import com.example.kampusappdemo.ui.view.detail.DetailViewmodel
import com.example.kampusappdemo.ui.view.home.HomeViewModel
import com.example.kampusappdemo.ui.view.payment.PaymentViewModel
import com.example.kampusappdemo.ui.view.profile.ProfileViewModel
import com.example.kampusappdemo.ui.view.search.SearchViewModel
import com.example.kampusappdemo.ui.view.setting.SettingsViewmodel
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
                            startDestination = Screens.Home.route
                        ) {
                            composable(Screens.Home.route) {
                                HomeScreens(
                                    viewModel = HomeViewModel(),
                                    navigate = { name, type, rating, city, image, desc ->
                                        navController.navigate(
                                            Screens.Detail.createRoute(
                                                name, type, rating, city, image, desc
                                            )
                                        )
                                    },
                                    actionTopBar = { navController.navigate(Screens.Chat.route) }
                                )
                            }
                            composable(Screens.Search.route) {
                                SearchScreens(
                                    modifier = Modifier.fillMaxSize(),
                                    navigate = { name, type, rating, city, image, desc ->
                                        navController.navigate(
                                            Screens.Detail.createRoute(
                                                name, type, rating, city, image, desc
                                            )
                                        )
                                    },
                                    viewModel = SearchViewModel()
                                )
                            }
                            composable(
                                Screens.Detail.route,
                                arguments = listOf(
                                    navArgument("name") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument("type") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument("rating") {
                                        type = NavType.FloatType
                                        defaultValue = 0.0
                                    },
                                    navArgument("city") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument("image") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument("desc") {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                ),
                            ) {
                                val name = it.arguments!!.getString("name", "")
                                val type = it.arguments!!.getString("type", "")
                                val rating = it.arguments!!.getFloat("rating", 0.0F)
                                val city = it.arguments!!.getString("city", "")
                                val image = it.arguments!!.getString("image", "")
                                val desc = it.arguments!!.getString("desc", "")
                                DetailScreens(
                                    modifier = Modifier,
                                    navigateUp = { navController.navigateUp() },
                                    navigate = { navController.navigate(Screens.Chat.route) },
                                    nameUniversity = name,
                                    typeUniversity = type,
                                    ratingUniversity = rating,
                                    nameCity = city,
                                    imageUniversity = image,
                                    nameDescription = desc,
                                    viewmodel = DetailViewmodel()
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
                                    navigate = { name,type, rating,city, image, desc ->
                                        navController.navigate(
                                            Screens.Detail.createRoute(
                                                name, type, rating,city, image, desc
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


@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry = navController.currentBackStackEntry
    return navBackStackEntry?.destination?.route
}

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
import com.example.kampusappdemo.data.kotpref.SettingPreferences
import com.example.kampusappdemo.module.admin.feature.chat.view.ChatAdminScreens
import com.example.kampusappdemo.module.admin.feature.chat.view.ListChatAdminScreens
import com.example.kampusappdemo.module.admin.feature.dashboard.view.DashboardScreens
import com.example.kampusappdemo.module.admin.feature.dashboard.view.DetailDashboardScreens
import com.example.kampusappdemo.module.admin.feature.dashboard.viewmodel.DashboardViewModel
import com.example.kampusappdemo.module.admin.feature.statistic.view.StatisticAdminScreens
import com.example.kampusappdemo.navigation.BottomNavigationDemo
import com.example.kampusappdemo.navigation.Screens
import com.example.kampusappdemo.ui.theme.DemoMarketAppTheme
import com.example.kampusappdemo.module.user.feature.booking.view.BookingScreens
import com.example.kampusappdemo.module.user.feature.booking.viewmodel.BookingViewModel
import com.example.kampusappdemo.module.user.feature.bookmark.view.BookmarkScreens
import com.example.kampusappdemo.module.user.feature.bookmark.viewmodel.BookmarkViewModel
import com.example.kampusappdemo.module.user.feature.chat.view.ChatUserScreens
import com.example.kampusappdemo.module.user.feature.detail.view.DetailScreens
import com.example.kampusappdemo.module.user.feature.detail.viewmodel.DetailViewmodel
import com.example.kampusappdemo.module.user.feature.home.view.HomeScreens
import com.example.kampusappdemo.module.user.feature.home.viewmodel.HomeViewModel
import com.example.kampusappdemo.module.guest.feature.login.view.ChangeTypeUserLogin
import com.example.kampusappdemo.module.guest.feature.login.view.SignIn
import com.example.kampusappdemo.module.guest.feature.login.view.userInstance.SignUpInstanceScreens
import com.example.kampusappdemo.module.guest.feature.login.view.userStudent.SignUpStudentScreens
import com.example.kampusappdemo.module.guest.feature.login.viewmodel.LoginViewModel
import com.example.kampusappdemo.module.guest.feature.needlogin.view.NeedLoginScreens
import com.example.kampusappdemo.module.user.feature.payment.viewmodel.PaymentViewModel
import com.example.kampusappdemo.module.guest.feature.profile.view.ProfileScreens
import com.example.kampusappdemo.module.guest.feature.profile.viewmodel.ProfileViewModel
import com.example.kampusappdemo.module.user.feature.search.view.SearchScreens
import com.example.kampusappdemo.module.user.feature.search.viewmodel.SearchViewModel
import com.example.kampusappdemo.module.guest.feature.setting.view.SettingsScreens
import com.example.kampusappdemo.module.guest.feature.setting.viewmodel.SettingsViewmodel
import com.example.kampusappdemo.module.guest.feature.splash.view.SplashScreens
import com.example.kampusappdemo.module.user.feature.chat.view.ListChatUserScreens
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
                                Screens.ChatUser.route -> null
                                Screens.ListChatUser.route -> null
                                Screens.ChatAdmin.route -> null
                                Screens.Payment.route -> null
                                Screens.DetailDashboard.route -> null
                                Screens.SignIn.route -> null
                                Screens.TypeUserSignUp.route -> null
                                Screens.SignUpStudent.route -> null
                                Screens.SignUpInstance.route -> null
                                Screens.Splash.route -> null
                                else -> NavigationBar(containerColor = MaterialTheme.colorScheme.inversePrimary) {
                                    //getting the list of bottom navigation items for our data class
                                    when (SettingPreferences.typeUser) {
                                        SettingPreferences.GUEST -> {
                                            BottomNavigationDemo().bottomNavItemGuestDemo()
                                                .forEachIndexed { index, navigationItem ->
                                                    //iterating all items with their respective indexes
                                                    NavigationBarItem(
                                                        selected = navigationItem.route == currentDestination?.route,
                                                        label = { Text(navigationItem.label) },
                                                        icon = {
                                                            Icon(
                                                                navigationItem.icon,
                                                                contentDescription = navigationItem.label,
                                                                tint = if (navigationItem.route == currentDestination?.route) {
                                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                                } else {
                                                                    MaterialTheme.colorScheme.onPrimaryContainer
                                                                }
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

                                        SettingPreferences.USER -> {
                                            BottomNavigationDemo().bottomNavItemUserDemo()
                                                .forEachIndexed { index, navigationItem ->
                                                    //iterating all items with their respective indexes
                                                    NavigationBarItem(
                                                        selected = navigationItem.route == currentDestination?.route,
                                                        label = { Text(navigationItem.label) },
                                                        icon = {
                                                            Icon(
                                                                navigationItem.icon,
                                                                contentDescription = navigationItem.label,
                                                                tint = if (navigationItem.route == currentDestination?.route) {
                                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                                } else {
                                                                    MaterialTheme.colorScheme.onPrimaryContainer
                                                                }
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

                                        SettingPreferences.ADMIN -> {
                                            BottomNavigationDemo().bottomNavItemAdminDemo()
                                                .forEachIndexed { index, navigationItem ->
                                                    //iterating all items with their respective indexes
                                                    NavigationBarItem(
                                                        selected = navigationItem.route == currentDestination?.route,
                                                        label = { Text(navigationItem.label) },
                                                        icon = {
                                                            Icon(
                                                                navigationItem.icon,
                                                                contentDescription = navigationItem.label,
                                                                tint = if (navigationItem.route == currentDestination?.route) {
                                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                                } else {
                                                                    MaterialTheme.colorScheme.onPrimaryContainer
                                                                }
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
                            }
                        }
                    ) {
                        NavHost(
                            modifier = Modifier.padding(it),
                            navController = navController,
                            startDestination = // Screens.ListChatAdmin.route
                            when {
                                SettingPreferences.isOnBoarding && GlobalState.isOnBoarding -> Screens.Splash.route
                                SettingPreferences.typeUser == SettingPreferences.USER -> Screens.Home.route
                                SettingPreferences.typeUser == SettingPreferences.ADMIN -> Screens.Dashboard.route
                                else -> Screens.SignIn.route
                            }
                        ) {
                            composable(Screens.Splash.route) {
                                SplashScreens(navigate = { navController.navigate(Screens.SignIn.route) })
                            }
                            composable(Screens.SignIn.route) {
                                SignIn(
                                    navigateUp = { navController.navigateUp() },
                                    navigateSignUp = { navController.navigate(Screens.TypeUserSignUp.route) },
                                    navigateHome = { navController.navigate(Screens.Home.route) },
                                    viewModel = LoginViewModel()
                                )
                            }
                            composable(Screens.TypeUserSignUp.route) {
                                ChangeTypeUserLogin(
                                    navigateUp = { navController.navigateUp() },
                                    changeStudent = { navController.navigate(Screens.SignUpStudent.route) },
                                    changeInstance = { navController.navigate(Screens.SignUpInstance.route) },
                                    viewModel = LoginViewModel()
                                )
                            }
                            composable(Screens.SignUpStudent.route) {
                                SignUpStudentScreens(
                                    navigateUp = { navController.navigateUp() },
                                    navigateSignIn = { navController.navigate(Screens.SignIn.route) },
                                    navigate = { navController.navigate(Screens.Home.route) },
                                    viewModel = LoginViewModel()
                                )
                            }
                            composable(Screens.SignUpInstance.route) {
                                SignUpInstanceScreens(
                                    navigateUp = { navController.navigateUp() },
                                    navigateSignIn = { navController.navigate(Screens.SignIn.route) },
                                    navigate = {
                                        navController.navigate(Screens.Dashboard.route)
                                    },
                                    viewModel = LoginViewModel()
                                )
                            }
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
                                    navigateToSignIn = { navController.navigate(Screens.SignIn.route) },
                                    actionTopBar = { navController.navigate(Screens.ListChatUser.route) }
                                )
                            }
                            composable(Screens.Search.route) {
                                SearchScreens(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    navigate = { index ->
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
                                    navArgument("index") {
                                        type = NavType.IntType
                                        defaultValue = 0
                                    },
                                ),
                            ) {
                                val index = it.arguments!!.getInt("index", 0)
                                DetailScreens(
                                    modifier = Modifier,
                                    navigateToSignIn = { navController.navigate(Screens.SignIn.route) },
                                    navigateUp = { navController.navigateUp() },
                                    navigate = { navController.navigate(Screens.ChatUser.route) },
                                    index = index,
                                    viewModel = DetailViewmodel()
                                )
                            }
                            composable(Screens.ChatUser.route) {
                                ChatUserScreens(
                                    navigateUp = { navController.navigateUp() }
                                )
                            }
                            composable(Screens.ListChatUser.route) {
                                ListChatUserScreens(
                                    navigate = { navController.navigate(Screens.ChatUser.route) },
                                    navigateUp = { navController.navigateUp() }
                                )
                            }
                            composable(Screens.ChatAdmin.route) {
                                ChatAdminScreens(
                                    navigateUp = { navController.navigateUp() }
                                )
                            }
                            composable(Screens.ListChatAdmin.route) {
                                ListChatAdminScreens(navigate = {
                                    navController.navigate(Screens.ChatAdmin.route)
                                })
                            }
                            composable(Screens.Booking.route) {
                                BookingScreens(
                                    navigate = { index ->
                                        navController.navigate(
                                            if (SettingPreferences.typeUser == SettingPreferences.GUEST) {
                                                Screens.NeedSignIn.route
                                            } else {
                                                Screens.Payment.createRoute(
                                                    index
                                                )
                                            }
                                        )
                                    },
                                    viewModel = BookingViewModel()
                                )
                            }
                            composable(Screens.Dashboard.route) {
                                DashboardScreens(
                                    navigate = { index ->
                                        navController.navigate(
                                            Screens.DetailDashboard.createRoute(
                                                index = index
                                            )
                                        )
                                    },
                                    viewModel = DashboardViewModel()
                                )
                            }
                            composable(
                                Screens.DetailDashboard.route,
                                arguments = listOf(
                                    navArgument("index") {
                                        type = NavType.IntType
                                        defaultValue = 0
                                    },
                                ),
                            ) {
                                val index = it.arguments!!.getInt("index", 0)
                                DetailDashboardScreens(
                                    index = index,
                                    navigateUp = { navController.navigateUp() },
                                    viewModel = DashboardViewModel()
                                )
                            }
                            composable(
                                Screens.Payment.route,
                                arguments = listOf(
                                    navArgument("index") {
                                        type = NavType.IntType
                                        defaultValue = 0
                                    },
                                ),
                            ) {
                                val index = it.arguments!!.getInt("index", 0)
                                PaymentScreens(
                                    modifier = Modifier,
                                    index = index,
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
                            composable(Screens.Statistic.route) {
                                StatisticAdminScreens()
                            }
                            composable(Screens.Profile.route) {
                                ProfileScreens(
                                    modifier = Modifier,
                                    viewModel = ProfileViewModel(),
                                    navigate = { navController.navigate(Screens.SignIn.route) },
                                    navigateToSetting = { navController.navigate(Screens.Setting.route) }
                                )
                            }
                            composable(Screens.Setting.route) {
                                SettingsScreens(
                                    modifier = Modifier,
                                    navigate = { navController.navigateUp() },
                                    viewmodel = SettingsViewmodel()
                                )
                            }
                            composable(Screens.NeedSignIn.route) {
                                NeedLoginScreens(
                                    navigateUp = { navController.navigateUp() },
                                    navigateToSigIn = { navController.navigate(Screens.SignIn.route) })
                            }
                        }
                    }
                }
            }
        }
    }
}
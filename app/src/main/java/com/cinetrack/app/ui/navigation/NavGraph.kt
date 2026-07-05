package com.cinetrack.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cinetrack.app.ui.screens.detail.DetailScreen
import com.cinetrack.app.ui.screens.home.HomeScreen
import com.cinetrack.app.ui.screens.search.SearchScreen
import com.cinetrack.app.ui.screens.settings.SettingsScreen
import com.cinetrack.app.ui.screens.watchlist.WatchlistScreen
import com.cinetrack.app.ui.screens.splash.SplashScreen

sealed class Screen(val route: String, val title: String, val icon: @Composable () -> Unit) {
    data object Splash : Screen("splash", "Splash", {})
    data object Home : Screen("home", "Home", { Icon(Icons.Filled.Home, contentDescription = "Home") })
    data object Search : Screen("search", "Cerca", { Icon(Icons.Filled.Search, contentDescription = "Cerca") })
    data object Watchlist : Screen("watchlist", "Watchlist", { Icon(Icons.Filled.BookmarkBorder, contentDescription = "Watchlist") })
    data object Settings : Screen("settings", "Impostazioni", { Icon(Icons.Filled.Settings, contentDescription = "Impostazioni") })
    data object Detail : Screen("detail/{movieId}", "Dettaglio", {}) {
        fun createRoute(movieId: Int) = "detail/$movieId"
    }
}

@Composable
fun CineTrackNavGraph() {
    val navController = rememberNavController()
    val bottomBarScreens = listOf(Screen.Home, Screen.Search, Screen.Watchlist, Screen.Settings)
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in bottomBarScreens.map { it.route }
    
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    bottomBarScreens.forEach { screen ->
                        NavigationBarItem(
                            icon = screen.icon,
                            label = { Text(screen.title) },
                            selected = currentRoute == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(onTimeout = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                })
            }
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Search.route) { SearchScreen(navController) }
            composable(Screen.Watchlist.route) { WatchlistScreen(navController) }
            composable(Screen.Settings.route) { SettingsScreen() }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) { backStackEntry ->
                val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable
                DetailScreen(movieId = movieId, navController = navController)
            }
        }
    }
}

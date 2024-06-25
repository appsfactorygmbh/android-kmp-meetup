package de.appsfactory.kmpmeetup.android.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.appsfactory.kmpmeetup.android.ui.database.DatabaseRoute
import de.appsfactory.kmpmeetup.android.ui.jokesflow.JokesRoute
import de.appsfactory.kmpmeetup.android.ui.overview.OverviewRoute
import de.appsfactory.kmpmeetup.android.ui.singlejoke.SingleJokeRoute

@Composable
fun MainNavHost() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Overview
    ) {
        composable<Screen.Overview> {
            OverviewRoute(
                onOpenScreen = { navController.navigate(it) }
            )
        }
        composable<Screen.SingleJoke> {
            SingleJokeRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<Screen.Jokes> {
            JokesRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<Screen.Database> {
            DatabaseRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
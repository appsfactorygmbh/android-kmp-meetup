package com.tobiapplications.kmpmeetup.android.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tobiapplications.kmpmeetup.android.ui.database.DatabaseRoute
import com.tobiapplications.kmpmeetup.android.ui.jokes.JokesRoute
import com.tobiapplications.kmpmeetup.android.ui.overview.OverviewRoute
import com.tobiapplications.kmpmeetup.android.ui.singlejoke.SingleJokeRoute

@Composable
fun MainNavHost() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Overview
    ) {
        composable<Overview> {
            OverviewRoute(
                onOpenScreen = { navController.navigate(it) }
            )
        }
        composable<SingleJoke> {
            SingleJokeRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<Jokes> {
            JokesRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<Database> {
            DatabaseRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
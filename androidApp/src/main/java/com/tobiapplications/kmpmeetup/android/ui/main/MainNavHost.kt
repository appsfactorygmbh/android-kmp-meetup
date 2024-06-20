package com.tobiapplications.kmpmeetup.android.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tobiapplications.kmpmeetup.android.ui.detail.DetailRoute
import com.tobiapplications.kmpmeetup.android.ui.overview.OverviewRoute

@Composable
fun MainNavHost() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Overview
    ) {
        composable<Overview> {
            OverviewRoute(
                onOpenDetailsClicked = {
                    navController.navigate(Details)
                }
            )
        }
        composable<Details> {
            DetailRoute(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
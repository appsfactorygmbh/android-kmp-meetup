package com.tobiapplications.kmpmeetup.android.ui.overview

import androidx.compose.runtime.Composable
import com.tobiapplications.kmpmeetup.android.ui.main.Screen

@Composable
fun OverviewRoute(
    onOpenScreen: (Screen) -> Unit,
) {
    OverviewScreen(
        onOpenScreen = onOpenScreen
    )
}
package de.appsfactory.kmpmeetup.android.ui.overview

import androidx.compose.runtime.Composable
import de.appsfactory.kmpmeetup.android.ui.main.Screen

@Composable
fun OverviewRoute(
    onOpenScreen: (Screen) -> Unit,
) {
    OverviewScreen(
        onOpenScreen = onOpenScreen
    )
}
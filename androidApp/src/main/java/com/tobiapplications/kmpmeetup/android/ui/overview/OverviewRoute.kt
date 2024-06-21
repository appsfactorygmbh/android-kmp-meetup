package com.tobiapplications.kmpmeetup.android.ui.overview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.tobiapplications.kmpmeetup.android.ui.main.Screen
import com.tobiapplications.kmpmeetup.uilayer.overview.OverviewViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OverviewRoute(
    onOpenScreen: (Screen) -> Unit,
    viewModel: OverviewViewModel = koinViewModel()
) {
    val jokeUiState by viewModel.jokeUiState.collectAsState()
    OverviewScreen(
        jokeUiState = jokeUiState,
        onRequestJokeClicked = { viewModel.requestJoke() },
        onOpenScreen = onOpenScreen
    )
}
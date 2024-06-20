package com.tobiapplications.kmpmeetup.android.ui.overview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.tobiapplications.kmpmeetup.viewmodel.overview.OverviewViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OverviewRoute(
    onOpenDetailsClicked: () -> Unit,
    viewModel: OverviewViewModel = koinViewModel()
) {
    val jokeUiState by viewModel.jokeUiState.collectAsState()
    OverviewScreen(
        jokeUiState = jokeUiState,
        onOpenDetailsClicked = onOpenDetailsClicked,
        onRequestJokeClicked = {
            viewModel.requestJoke()
        }
    )
}
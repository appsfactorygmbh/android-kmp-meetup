package com.tobiapplications.kmpmeetup.android.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.tobiapplications.kmpmeetup.viewmodel.main.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainRoute(
    viewModel: MainViewModel = koinViewModel()
) {
    val mainUiState by viewModel.menuUiState.collectAsState()
    MainScreen(
        mainUiState = mainUiState,
        onRequestJokeClicked = {
            viewModel.requestJoke()
        }
    )
}
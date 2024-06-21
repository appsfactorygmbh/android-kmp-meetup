package com.tobiapplications.kmpmeetup.android.ui.jokes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun JokesRoute(
    onNavigateBack: () -> Unit,
    viewModel: JokesViewModel = koinViewModel()
) {
    val jokesUiState: JokesUiState by viewModel.jokesUiState.collectAsState()
    JokesScreen(
        jokesUiState = jokesUiState,
        onNavigateBack = onNavigateBack
    )
}
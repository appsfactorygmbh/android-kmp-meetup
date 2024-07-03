package de.appsfactory.kmpmeetup.android.ui.jokesflow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun JokesFlowRoute(
    onNavigateBack: () -> Unit,
    viewModel: JokesFlowViewModel = koinViewModel()
) {
    val jokesFlowUiState: JokesFlowUiState by viewModel.jokesFlowUiState.collectAsState()
    JokesFlowScreen(
        jokesFlowUiState = jokesFlowUiState,
        onNavigateBack = onNavigateBack
    )
}
package de.appsfactory.kmpmeetup.android.ui.jokesflow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun JokesFlowRoute(
    onNavigateBack: () -> Unit,
    viewModel: JokesFlowViewModel = koinViewModel()
) {
    val jokesFlowUiState: JokesFlowUiState by viewModel.jokesFlowUiState.collectAsStateWithLifecycle()
    JokesFlowScreen(
        jokesFlowUiState = jokesFlowUiState,
        onNavigateBack = onNavigateBack
    )
}
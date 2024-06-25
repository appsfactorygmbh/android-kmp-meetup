package de.appsfactory.kmpmeetup.android.ui.singlejoke

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import de.appsfactory.kmpmeetup.uilayer.SingleJokeUiState
import de.appsfactory.kmpmeetup.uilayer.SingleJokeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SingleJokeRoute(
    onNavigateBack: () -> Unit,
    viewModel: SingleJokeViewModel = koinViewModel()
) {
    val singleJokeUiState: SingleJokeUiState by viewModel.singleJokeUiState.collectAsState()
    SingleJokeScreen(
        singleJokeUiState = singleJokeUiState,
        onNavigateBack = onNavigateBack,
        onRequestJokeClicked = viewModel::requestJoke
    )
}
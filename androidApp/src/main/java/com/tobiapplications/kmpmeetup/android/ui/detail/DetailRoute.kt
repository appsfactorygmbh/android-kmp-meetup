package com.tobiapplications.kmpmeetup.android.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailRoute(
    onNavigateBack: () -> Unit,
    viewModel: DetailViewModel = koinViewModel()
) {
    val detailUiState: DetailUiState by viewModel.detailUiState.collectAsState()
    DetailScreen(
        detailUiState = detailUiState,
        onNavigateBack = onNavigateBack
    )
}
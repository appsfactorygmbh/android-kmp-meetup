package com.tobiapplications.kmpmeetup.android.ui.database

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun DatabaseRoute(
    onNavigateBack: () -> Unit,
    viewModel: DatabaseViewModel = koinViewModel()
) {
    val databaseUiState by viewModel.databaseUiState.collectAsState()
    DatabaseScreen(
        databaseUiState = databaseUiState,
        onNavigateBack = onNavigateBack,
        onStoreNameClicked = viewModel::storeName,
        onSnackbarDismissed = viewModel::onSnackbarDismissed
    )
}
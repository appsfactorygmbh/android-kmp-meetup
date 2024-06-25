package de.appsfactory.kmpmeetup.android.ui.database

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
    val usernameStoredSuccessful by viewModel.userNameStoredSuccessfully.collectAsState()
    DatabaseScreen(
        databaseUiState = databaseUiState,
        userNameStoredSuccessful = usernameStoredSuccessful,
        onNavigateBack = onNavigateBack,
        onStoreUserNameClicked = viewModel::storeUserName,
        onSnackbarDismissed = viewModel::onSnackbarDismissed
    )
}
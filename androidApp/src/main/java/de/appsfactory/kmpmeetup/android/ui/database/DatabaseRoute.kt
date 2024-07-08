package de.appsfactory.kmpmeetup.android.ui.database

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun DatabaseRoute(
    onNavigateBack: () -> Unit,
    viewModel: DatabaseViewModel = koinViewModel()
) {
    val databaseUiState by viewModel.databaseUiState.collectAsStateWithLifecycle()
    val usernameStoredSuccessful by viewModel.userNameStoredSuccessfully.collectAsStateWithLifecycle()
    DatabaseScreen(
        databaseUiState = databaseUiState,
        userNameStoredSuccessful = usernameStoredSuccessful,
        onNavigateBack = onNavigateBack,
        onStoreUserNameClicked = viewModel::storeUserName,
        onSnackbarDismissed = viewModel::onSnackbarDismissed
    )
}
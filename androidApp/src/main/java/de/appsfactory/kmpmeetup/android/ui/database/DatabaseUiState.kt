package de.appsfactory.kmpmeetup.android.ui.database

sealed interface DatabaseUiState {

    data object Idle : DatabaseUiState

    data class Data(
        val userName: String
    ) : DatabaseUiState
}
package com.tobiapplications.kmpmeetup.android.ui.database

sealed interface DatabaseUiState {

    data object Idle : DatabaseUiState

    data class Data(
        val name: String
    ) : DatabaseUiState
}
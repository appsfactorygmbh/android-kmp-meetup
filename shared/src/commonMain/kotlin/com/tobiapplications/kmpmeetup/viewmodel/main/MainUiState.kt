package com.tobiapplications.kmpmeetup.viewmodel.main

import com.tobiapplications.kmpmeetup.model.JokeResponse

sealed interface MainUiState {

    data object Idle : MainUiState

    data object Loading : MainUiState

    data class Data(
        val jokeResponse: JokeResponse
    ) : MainUiState
}
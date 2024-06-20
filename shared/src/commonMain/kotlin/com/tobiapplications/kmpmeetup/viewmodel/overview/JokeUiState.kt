package com.tobiapplications.kmpmeetup.viewmodel.overview

import com.tobiapplications.kmpmeetup.model.JokeResponse

sealed interface JokeUiState {

    data object Idle : JokeUiState

    data object Loading : JokeUiState

    data class Data(
        val jokeResponse: JokeResponse
    ) : JokeUiState
}
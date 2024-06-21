package com.tobiapplications.kmpmeetup.uilayer.overview

import com.tobiapplications.kmpmeetup.domainlayer.model.Joke

sealed interface JokeUiState {

    data object Idle : JokeUiState

    data object Loading : JokeUiState

    data class Data(
        val joke: Joke
    ) : JokeUiState
}
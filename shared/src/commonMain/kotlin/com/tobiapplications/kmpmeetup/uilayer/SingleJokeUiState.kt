package com.tobiapplications.kmpmeetup.uilayer

import com.tobiapplications.kmpmeetup.domainlayer.model.Joke

sealed interface SingleJokeUiState {

    data object Idle : SingleJokeUiState

    data object Loading : SingleJokeUiState

    data class Data(
        val joke: Joke
    ) : SingleJokeUiState
}
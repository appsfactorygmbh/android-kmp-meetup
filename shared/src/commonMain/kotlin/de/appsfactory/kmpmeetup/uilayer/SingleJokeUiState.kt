package de.appsfactory.kmpmeetup.uilayer

import de.appsfactory.kmpmeetup.domainlayer.model.Joke

sealed interface SingleJokeUiState {

    data object Idle : SingleJokeUiState

    data object Loading : SingleJokeUiState

    data class Data(
        val joke: Joke
    ) : SingleJokeUiState
}
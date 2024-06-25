package de.appsfactory.kmpmeetup.android.ui.jokesflow

import de.appsfactory.kmpmeetup.domainlayer.model.Joke

sealed interface JokesFlowUiState {

    data object Loading : JokesFlowUiState

    data class Data(
        val joke: Joke
    ) : JokesFlowUiState
}
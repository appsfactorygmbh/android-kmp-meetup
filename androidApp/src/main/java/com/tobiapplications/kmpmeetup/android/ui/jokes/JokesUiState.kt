package com.tobiapplications.kmpmeetup.android.ui.jokes

import com.tobiapplications.kmpmeetup.domainlayer.model.Joke

sealed interface JokesUiState {

    data object Loading : JokesUiState

    data class Data(
        val joke: Joke
    ) : JokesUiState
}
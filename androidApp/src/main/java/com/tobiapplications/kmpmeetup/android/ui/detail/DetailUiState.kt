package com.tobiapplications.kmpmeetup.android.ui.detail

import com.tobiapplications.kmpmeetup.model.JokeResponse

sealed interface DetailUiState {

    data object Loading : DetailUiState

    data class Data(
        val jokeResponse: JokeResponse
    ) : DetailUiState
}
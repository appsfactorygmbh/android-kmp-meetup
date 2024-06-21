package com.tobiapplications.kmpmeetup.android.ui.jokes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetJokesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class JokesViewModel(
    getJokesUseCase: GetJokesUseCase
) : ViewModel() {

    val jokesUiState: StateFlow<JokesUiState> = getJokesUseCase.invoke().map {
        JokesUiState.Data(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = JokesUiState.Loading
    )
}
package com.tobiapplications.kmpmeetup.viewmodel.overview

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import com.tobiapplications.kmpmeetup.domain.GetJokeUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class OverviewViewModel(
    private val getJokeUseCase: GetJokeUseCase
) : ViewModel() {

    private val _jokeUiState = MutableStateFlow<JokeUiState>(viewModelScope, JokeUiState.Idle)
    @NativeCoroutinesState
    val jokeUiState = _jokeUiState.asStateFlow()

    fun requestJoke() {
        viewModelScope.launch {
            _jokeUiState.update { JokeUiState.Loading }
            delay(1000)
            val joke = getJokeUseCase.invoke()
            _jokeUiState.update { JokeUiState.Data(jokeResponse = joke) }
        }
    }
}
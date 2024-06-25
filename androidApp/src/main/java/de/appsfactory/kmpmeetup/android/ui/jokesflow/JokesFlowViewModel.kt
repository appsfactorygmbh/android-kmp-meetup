package de.appsfactory.kmpmeetup.android.ui.jokesflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetJokesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class JokesFlowViewModel(
    getJokesUseCase: GetJokesUseCase
) : ViewModel() {

    val jokesFlowUiState: StateFlow<JokesFlowUiState> = getJokesUseCase.invoke().map {
        JokesFlowUiState.Data(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = JokesFlowUiState.Loading
    )
}
package com.tobiapplications.kmpmeetup.android.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tobiapplications.kmpmeetup.domain.GetJokesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    getJokesUseCase: GetJokesUseCase
) : ViewModel() {

    val detailUiState: StateFlow<DetailUiState> = getJokesUseCase.invoke().map {
        DetailUiState.Data(it)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = DetailUiState.Loading
    )
}
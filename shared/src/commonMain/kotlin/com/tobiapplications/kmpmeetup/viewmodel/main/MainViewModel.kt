package com.tobiapplications.kmpmeetup.viewmodel.main

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import com.tobiapplications.kmpmeetup.network.datasource.NetworkDatasourceImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


open class MainViewModel : ViewModel() {

    private val datasource = NetworkDatasourceImpl()

    private val _menuUiState = MutableStateFlow<MainUiState>(viewModelScope, MainUiState.Idle)
    @NativeCoroutinesState
    val menuUiState = _menuUiState.asStateFlow()

    fun requestJoke() {
        viewModelScope.launch {
            _menuUiState.update { MainUiState.Loading }
            delay(1000)
            val joke = datasource.getJoke()
            _menuUiState.update { MainUiState.Data(jokeResponse = joke) }
        }
    }
}

package de.appsfactory.kmpmeetup.uilayer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetJokeUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class SingleJokeViewModel(
    private val getJokeUseCase: GetJokeUseCase
) : ViewModel() {

    private val _singleJokeUiState = MutableStateFlow<SingleJokeUiState>(viewModelScope, SingleJokeUiState.Idle)
    @NativeCoroutinesState
    val singleJokeUiState = _singleJokeUiState.asStateFlow()

    fun requestJoke() {
        viewModelScope.launch {
            _singleJokeUiState.update { SingleJokeUiState.Loading }
            delay(1000)
            val joke = getJokeUseCase.invoke()
            _singleJokeUiState.update { SingleJokeUiState.Data(joke = joke) }
        }
    }
}
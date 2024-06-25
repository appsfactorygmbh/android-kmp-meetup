package de.appsfactory.kmpmeetup.android.ui.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.appsfactory.kmpmeetup.domainlayer.model.UserName
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetUserNameUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.StoreUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DatabaseViewModel(
    getUserNameUseCase: GetUserNameUseCase,
    private val storeUserNameUseCase: StoreUserNameUseCase,
) : ViewModel() {

    val userNameStoredSuccessfully = MutableStateFlow(false)
    val databaseUiState: StateFlow<DatabaseUiState> = getUserNameUseCase.invoke().map {
        DatabaseUiState.Data(
            userName = it.text,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = DatabaseUiState.Idle
    )

    fun storeUserName(userName: String) {
        viewModelScope.launch {
            val result = storeUserNameUseCase.invoke(UserName(text = userName))
            if (result) {
                userNameStoredSuccessfully.update { true }
            }
        }
    }

    fun onSnackbarDismissed() {
        userNameStoredSuccessfully.update { false }
    }
}
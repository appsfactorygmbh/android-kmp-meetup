package com.tobiapplications.kmpmeetup.android.ui.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetNameUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.StoreNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DatabaseViewModel(
    getNameUseCase: GetNameUseCase,
    private val storeNameUseCase: StoreNameUseCase,
) : ViewModel() {

    private val storedName = getNameUseCase.invoke()
    private val nameStoredSuccessful = MutableStateFlow(false)

    val databaseUiState: StateFlow<DatabaseUiState> = combine(
        storedName, nameStoredSuccessful
    ) { name, success ->
        DatabaseUiState.Data(
            name = name.text,
            showSuccessSnackbar = success
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = DatabaseUiState.Idle
        )


    fun storeName(text: String) {
        viewModelScope.launch {
            storeNameUseCase.invoke(Name(text = text))
            nameStoredSuccessful.update { true }
        }
    }

    fun onSnackbarDismissed() {
        nameStoredSuccessful.update { false }
    }
}
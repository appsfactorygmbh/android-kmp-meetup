package com.tobiapplications.kmpmeetup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class PlatformViewModel: ViewModel() {

    actual val coroutineScope: CoroutineScope
        get() = viewModelScope
}
package com.tobiapplications.kmpmeetup.uilayer

import kotlinx.coroutines.CoroutineScope


expect open class PlatformViewModel() {

    val coroutineScope: CoroutineScope
}

open class SharedViewModel: PlatformViewModel()
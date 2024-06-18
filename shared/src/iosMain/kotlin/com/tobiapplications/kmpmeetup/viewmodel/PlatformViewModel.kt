package com.tobiapplications.kmpmeetup.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


actual open class PlatformViewModel {

    actual val coroutineScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob())
}
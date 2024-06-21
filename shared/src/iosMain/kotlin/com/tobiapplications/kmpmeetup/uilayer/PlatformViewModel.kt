package com.tobiapplications.kmpmeetup.uilayer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


actual open class PlatformViewModel {

    actual val coroutineScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob())
}
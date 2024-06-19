package com.tobiapplications.kmpmeetup.di

import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin


object Koin : KoinComponent {
    fun initKoin(): KoinApplication {
        return startKoin {
            modules(KoinShared.sharedModules)
        }
    }
}

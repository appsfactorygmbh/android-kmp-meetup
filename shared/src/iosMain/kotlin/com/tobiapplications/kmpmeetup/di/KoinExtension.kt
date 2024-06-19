package com.tobiapplications.kmpmeetup.di

import com.tobiapplications.kmpmeetup.Platform
import com.tobiapplications.kmpmeetup.domain.GetJokeUseCase
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

val Koin.platform: Platform
    get() = get()

object Usecases: KoinComponent {
    val getJokeUseCase: GetJokeUseCase
        get() = get()
}

val Koin.usecases: Usecases
    get() = Usecases
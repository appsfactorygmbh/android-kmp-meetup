package com.tobiapplications.kmpmeetup.di

import com.tobiapplications.kmpmeetup.Platform
import com.tobiapplications.kmpmeetup.domain.GetJokeUseCase
import com.tobiapplications.kmpmeetup.domain.GetJokesUseCase
import com.tobiapplications.kmpmeetup.domain.GetPlatformUseCase
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

val Koin.platform: Platform
    get() = get()

object Usecases : KoinComponent {
    val getJokeUseCase: GetJokeUseCase = get()
    val getJokesUseCase: GetJokesUseCase = get()
    val getPlatformUseCase: GetPlatformUseCase = get()
}

val Koin.usecases: Usecases
    get() = Usecases
package com.tobiapplications.kmpmeetup.utils.di

import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetJokeUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetJokesUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetNameUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.StoreNameUseCase
import com.tobiapplications.kmpmeetup.utils.Platform
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

val Koin.platform: Platform
    get() = get()

object Usecases : KoinComponent {
    val getJokeUseCase: GetJokeUseCase = get()
    val getJokesUseCase: GetJokesUseCase = get()
    val storeNameUseCase: StoreNameUseCase = get()
    val getNameUseCase: GetNameUseCase = get()
}

val Koin.usecases: Usecases
    get() = Usecases
package de.appsfactory.kmpmeetup.utils.di

import de.appsfactory.kmpmeetup.domainlayer.usecase.GetJokeUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetJokesUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetUserNameUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.StoreUserNameUseCase
import de.appsfactory.kmpmeetup.utils.Platform
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

val Koin.platform: Platform
    get() = get()

object Usecases : KoinComponent {
    val getJokeUseCase: GetJokeUseCase = get()
    val getJokesUseCase: GetJokesUseCase = get()
    val storeUserNameUseCase: StoreUserNameUseCase = get()
    val getUserNameUseCase: GetUserNameUseCase = get()
}

val Koin.usecases: Usecases
    get() = Usecases
package de.appsfactory.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.datalayer.repository.joke.JokeRepository
import de.appsfactory.kmpmeetup.domainlayer.model.Joke

class GetJokeUseCase(
    private val jokeRepository: JokeRepository
) {

    @NativeCoroutines
    suspend fun invoke() : Joke {
        return jokeRepository.getJoke()
    }
}
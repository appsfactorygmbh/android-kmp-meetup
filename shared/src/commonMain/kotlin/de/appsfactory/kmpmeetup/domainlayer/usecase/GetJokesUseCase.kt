package de.appsfactory.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.datalayer.repository.joke.JokeRepository
import de.appsfactory.kmpmeetup.domainlayer.model.Joke
import kotlinx.coroutines.flow.Flow

class GetJokesUseCase(
    private val jokeRepository: JokeRepository
) {

    @NativeCoroutines
    fun invoke() : Flow<Joke> {
        return jokeRepository.getJokes()
    }
}
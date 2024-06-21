package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.datalayer.repository.joke.JokeRepository
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke
import kotlinx.coroutines.flow.Flow

class GetJokesUseCase(
    private val jokeRepository: JokeRepository
) {

    @NativeCoroutines
    fun invoke() : Flow<Joke> {
        return jokeRepository.getJokes()
    }
}
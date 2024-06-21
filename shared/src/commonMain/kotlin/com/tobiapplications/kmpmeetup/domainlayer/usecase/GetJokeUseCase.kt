package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.datalayer.repository.joke.JokeRepository
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke

class GetJokeUseCase(
    private val jokeRepository: JokeRepository
) {

    @NativeCoroutines
    suspend fun invoke() : Joke {
        return jokeRepository.getJoke()
    }
}
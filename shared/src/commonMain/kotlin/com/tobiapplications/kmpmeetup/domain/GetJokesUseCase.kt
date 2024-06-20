package com.tobiapplications.kmpmeetup.domain

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.data.joke.JokeRepository
import com.tobiapplications.kmpmeetup.model.JokeResponse
import kotlinx.coroutines.flow.Flow

class GetJokesUseCase(
    private val jokeRepository: JokeRepository
) {

    @NativeCoroutines
    fun invoke() : Flow<JokeResponse> {
        return jokeRepository.getJokes()
    }
}
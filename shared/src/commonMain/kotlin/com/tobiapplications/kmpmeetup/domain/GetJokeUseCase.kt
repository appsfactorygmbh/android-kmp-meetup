package com.tobiapplications.kmpmeetup.domain

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.data.JokeRepository
import com.tobiapplications.kmpmeetup.model.JokeResponse

class GetJokeUseCase(
    private val jokeRepository: JokeRepository
) {

    @NativeCoroutines
    suspend fun invoke() : JokeResponse {
        return jokeRepository.getJoke()
    }
}
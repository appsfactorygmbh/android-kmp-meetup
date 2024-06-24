package com.tobiapplications.kmpmeetup.datalayer.repository.joke

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokeRepository {

    @NativeCoroutines
    suspend fun getJoke() : Joke
    @NativeCoroutines
    fun getJokes(): Flow<Joke>
}
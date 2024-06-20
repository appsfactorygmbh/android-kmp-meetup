package com.tobiapplications.kmpmeetup.data.joke

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.model.JokeResponse
import kotlinx.coroutines.flow.Flow

interface JokeRepository {

    @NativeCoroutines
    suspend fun getJoke() : JokeResponse
    fun getJokes(): Flow<JokeResponse>
}
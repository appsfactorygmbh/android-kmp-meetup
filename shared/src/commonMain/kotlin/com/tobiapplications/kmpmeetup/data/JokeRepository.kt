package com.tobiapplications.kmpmeetup.data

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.model.JokeResponse

interface JokeRepository {

    @NativeCoroutines
    suspend fun getJoke() : JokeResponse
}
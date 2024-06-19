package com.tobiapplications.kmpmeetup.network.datasource

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.model.JokeResponse

interface NetworkDatasource {

    @NativeCoroutines
    suspend fun getJoke() : JokeResponse
}
package com.tobiapplications.kmpmeetup.datalayer.datasource.remote

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke

interface JokeNetworkDatasource {

    @NativeCoroutines
    suspend fun getJoke() : Joke
}
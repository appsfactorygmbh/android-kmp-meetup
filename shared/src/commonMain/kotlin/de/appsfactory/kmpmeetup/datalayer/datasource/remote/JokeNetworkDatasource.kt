package de.appsfactory.kmpmeetup.datalayer.datasource.remote

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.domainlayer.model.Joke

interface JokeNetworkDatasource {

    @NativeCoroutines
    suspend fun getJoke() : Joke
}
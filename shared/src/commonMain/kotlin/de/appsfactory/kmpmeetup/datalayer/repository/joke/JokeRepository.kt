package de.appsfactory.kmpmeetup.datalayer.repository.joke

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.domainlayer.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokeRepository {

    @NativeCoroutines
    suspend fun getJoke() : Joke

    @NativeCoroutines
    fun getJokes(): Flow<Joke>
}
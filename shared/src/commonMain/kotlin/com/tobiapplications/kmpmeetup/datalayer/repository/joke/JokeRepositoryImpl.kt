package com.tobiapplications.kmpmeetup.datalayer.repository.joke

import com.tobiapplications.kmpmeetup.domainlayer.model.Joke
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.JokeNetworkDatasource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepositoryImpl(
    private val jokeNetworkDatasource: JokeNetworkDatasource
): JokeRepository {

    override suspend fun getJoke(): Joke {
        return jokeNetworkDatasource.getJoke()
    }

    override fun getJokes(): Flow<Joke> {
        return flow {
            while (true) {
                emit(getJoke())
                delay(5000)
            }
        }
    }
}
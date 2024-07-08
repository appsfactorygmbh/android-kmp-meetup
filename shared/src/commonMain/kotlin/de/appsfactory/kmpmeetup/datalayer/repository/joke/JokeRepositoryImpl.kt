package de.appsfactory.kmpmeetup.datalayer.repository.joke

import de.appsfactory.kmpmeetup.datalayer.datasource.remote.JokeNetworkDatasource
import de.appsfactory.kmpmeetup.domainlayer.model.Joke
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive

class JokeRepositoryImpl(
    private val jokeNetworkDatasource: JokeNetworkDatasource
): JokeRepository {

    override suspend fun getJoke(): Joke {
        return jokeNetworkDatasource.getJoke()
    }

    override fun getJokes(): Flow<Joke> {
        return flow {
            while (currentCoroutineContext().isActive) {
                emit(getJoke())
                delay(5000)
            }
        }
    }
}
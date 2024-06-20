package com.tobiapplications.kmpmeetup.data.joke

import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.network.datasource.NetworkDatasource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokeRepositoryImpl(
    private val networkDatasource: NetworkDatasource
): JokeRepository {

    override suspend fun getJoke(): JokeResponse {
        return networkDatasource.getJoke()
    }

    override fun getJokes(): Flow<JokeResponse> {
        return flow {
            while (true) {
                emit(getJoke())
                delay(5000)
            }
        }
    }
}
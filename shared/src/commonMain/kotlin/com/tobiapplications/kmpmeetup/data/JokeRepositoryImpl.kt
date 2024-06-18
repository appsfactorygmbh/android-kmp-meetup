package com.tobiapplications.kmpmeetup.data

import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.network.datasource.NetworkDatasource

class JokeRepositoryImpl(
    private val networkDatasource: NetworkDatasource
): JokeRepository {

    override suspend fun getJoke(): JokeResponse {
        return networkDatasource.getJoke()
    }
}
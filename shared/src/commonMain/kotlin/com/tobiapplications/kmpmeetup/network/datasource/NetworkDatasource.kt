package com.tobiapplications.kmpmeetup.network.datasource

import com.tobiapplications.kmpmeetup.model.JokeResponse

interface NetworkDatasource {

    suspend fun getJoke() : JokeResponse
}
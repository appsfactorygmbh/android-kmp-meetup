package com.tobiapplications.kmpmeetup.network.datasource

import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.network.client.HttpClientProvider
import com.tobiapplications.kmpmeetup.network.mapper.mapToEntity
import com.tobiapplications.kmpmeetup.network.model.ApiJokeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val JOKE_PATH = "joke/Programming"
private const val LANGUAGE_QUERY_PARAM = "lang"
private const val LANGUAGE_ENGLISH = "EN"

class NetworkDatasourceImpl(
    private val httpClientProvider: HttpClientProvider
) : NetworkDatasource {

    private val httpClient: HttpClient by lazy {
        httpClientProvider.httpClient
    }

    override suspend fun getJoke(): JokeResponse {
        val jokeResponse = httpClient.get(JOKE_PATH) {
            parameter(LANGUAGE_QUERY_PARAM, LANGUAGE_ENGLISH)
        }.body<ApiJokeResponse>().also {
            println(it)
        }
        return jokeResponse.mapToEntity()
    }
}

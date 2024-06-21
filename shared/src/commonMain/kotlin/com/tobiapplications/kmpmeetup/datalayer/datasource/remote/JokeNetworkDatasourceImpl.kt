package com.tobiapplications.kmpmeetup.datalayer.datasource.remote

import com.tobiapplications.kmpmeetup.domainlayer.model.Joke
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.client.HttpClientProvider
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.mapper.mapToEntity
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.model.ApiJoke
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val JOKE_PATH = "joke/Programming"
private const val LANGUAGE_QUERY_PARAM = "lang"
private const val LANGUAGE_ENGLISH = "EN"

class JokeNetworkDatasourceImpl(
    private val httpClientProvider: HttpClientProvider
) : JokeNetworkDatasource {

    private val httpClient: HttpClient by lazy {
        httpClientProvider.httpClient
    }

    override suspend fun getJoke(): Joke {
        val jokeResponse = httpClient.get(JOKE_PATH) {
            parameter(LANGUAGE_QUERY_PARAM, LANGUAGE_ENGLISH)
        }.body<ApiJoke>().also {
            println(it)
        }
        return jokeResponse.mapToEntity()
    }
}

package com.tobiapplications.kmpmeetup.network.datasource

import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.network.mapper.mapToEntity
import com.tobiapplications.kmpmeetup.network.model.ApiJokeResponse
import com.tobiapplications.kmpmeetup.network.utils.HttpLogger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val JOKE_BASE_URL = "v2.jokeapi.dev"
private const val JOKE_PATH = "joke/Programming"
private const val LANGUAGE_QUERY_PARAM = "lang"
private const val LANGUAGE_ENGLISH = "EN"

class NetworkDatasourceImpl : NetworkDatasource {

    private val httpClient = HttpClient {
        defaultRequest {
            host = JOKE_BASE_URL
            url {
                protocol = URLProtocol.HTTPS
            }
        }
        install(Logging) {
            logger = HttpLogger()
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
        }
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

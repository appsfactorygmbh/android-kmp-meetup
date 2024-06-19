package com.tobiapplications.kmpmeetup.network.client

import com.tobiapplications.kmpmeetup.network.logger.HttpLoggerProvider
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val JOKE_BASE_URL = "v2.jokeapi.dev"

class HttpClientProviderImpl(
    private val httpLoggerProvider: HttpLoggerProvider
) : HttpClientProvider{

    override val httpClient = HttpClient {
        defaultRequest {
            host = JOKE_BASE_URL
            url {
                protocol = URLProtocol.HTTPS
            }
        }
        install(Logging) {
            logger = httpLoggerProvider.logger
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
}
package de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.client

import io.ktor.client.HttpClient

interface HttpClientProvider {

    val httpClient: HttpClient
}
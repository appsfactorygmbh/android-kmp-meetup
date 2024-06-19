package com.tobiapplications.kmpmeetup.network.client

import io.ktor.client.HttpClient

interface HttpClientProvider {

    val httpClient: HttpClient
}
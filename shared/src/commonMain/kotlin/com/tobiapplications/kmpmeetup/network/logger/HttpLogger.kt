package com.tobiapplications.kmpmeetup.network.logger

import io.ktor.client.plugins.logging.Logger

class HttpLogger : Logger {
    override fun log(message: String) {
        println(message)
    }
}
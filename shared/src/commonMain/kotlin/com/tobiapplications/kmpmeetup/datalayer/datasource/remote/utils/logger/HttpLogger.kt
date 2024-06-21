package com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.logger

import io.ktor.client.plugins.logging.Logger

class HttpLogger : Logger {
    override fun log(message: String) {
        println(message)
    }
}
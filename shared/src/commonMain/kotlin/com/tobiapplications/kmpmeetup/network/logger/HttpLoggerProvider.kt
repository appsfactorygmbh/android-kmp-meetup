package com.tobiapplications.kmpmeetup.network.logger

import io.ktor.client.plugins.logging.Logger

interface HttpLoggerProvider {

    val logger: Logger
}
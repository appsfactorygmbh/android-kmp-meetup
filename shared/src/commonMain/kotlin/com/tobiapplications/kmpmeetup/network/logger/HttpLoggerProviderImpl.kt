package com.tobiapplications.kmpmeetup.network.logger

import io.ktor.client.plugins.logging.Logger

class HttpLoggerProviderImpl: HttpLoggerProvider {

    override val logger: Logger
        get() = HttpLogger()
}
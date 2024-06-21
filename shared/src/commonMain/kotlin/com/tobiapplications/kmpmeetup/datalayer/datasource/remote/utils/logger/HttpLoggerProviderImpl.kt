package com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.logger

import io.ktor.client.plugins.logging.Logger

class HttpLoggerProviderImpl: HttpLoggerProvider {

    override val logger: Logger
        get() = HttpLogger()
}
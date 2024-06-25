package de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.logger

import io.ktor.client.plugins.logging.Logger

interface HttpLoggerProvider {

    val logger: Logger
}
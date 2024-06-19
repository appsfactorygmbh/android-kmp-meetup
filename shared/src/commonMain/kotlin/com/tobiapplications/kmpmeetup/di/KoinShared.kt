package com.tobiapplications.kmpmeetup.di

import com.tobiapplications.kmpmeetup.Platform
import com.tobiapplications.kmpmeetup.data.JokeRepository
import com.tobiapplications.kmpmeetup.data.JokeRepositoryImpl
import com.tobiapplications.kmpmeetup.domain.GetJokeUseCase
import com.tobiapplications.kmpmeetup.getPlatform
import com.tobiapplications.kmpmeetup.network.client.HttpClientProvider
import com.tobiapplications.kmpmeetup.network.client.HttpClientProviderImpl
import com.tobiapplications.kmpmeetup.network.datasource.NetworkDatasource
import com.tobiapplications.kmpmeetup.network.datasource.NetworkDatasourceImpl
import com.tobiapplications.kmpmeetup.network.logger.HttpLoggerProvider
import com.tobiapplications.kmpmeetup.network.logger.HttpLoggerProviderImpl
import org.koin.dsl.module

object KoinShared {
    private val platformModule = module {
        single<Platform> { getPlatform() }
    }

    private val networkModule = module {
        single<HttpLoggerProvider> {
            HttpLoggerProviderImpl()
        }
        single<HttpClientProvider> {
            HttpClientProviderImpl(
                httpLoggerProvider = get()
            )
        }
        single<NetworkDatasource> {
            NetworkDatasourceImpl(
                httpClientProvider = get()
            )
        }
    }

    private val dataModule = module {
        single<JokeRepository> {
            JokeRepositoryImpl(
                networkDatasource = get()
            )
        }
    }

    private val domainModule = module {
        factory {
            GetJokeUseCase(
                jokeRepository = get()
            )
        }
    }

    val sharedModules = listOf(
        platformModule,
        networkModule,
        dataModule,
        domainModule
    )
}

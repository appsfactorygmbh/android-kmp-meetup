package com.tobiapplications.kmpmeetup.utils.di

import com.tobiapplications.kmpmeetup.datalayer.datasource.local.LocalDatasource
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.LocalDatasourceImpl
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.database.KMPDatabase
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.JokeNetworkDatasource
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.JokeNetworkDatasourceImpl
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.client.HttpClientProvider
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.client.HttpClientProviderImpl
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.logger.HttpLoggerProvider
import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.logger.HttpLoggerProviderImpl
import com.tobiapplications.kmpmeetup.datalayer.repository.database.DatabaseRepository
import com.tobiapplications.kmpmeetup.datalayer.repository.database.DatabaseRepositoryImpl
import com.tobiapplications.kmpmeetup.datalayer.repository.joke.JokeRepository
import com.tobiapplications.kmpmeetup.datalayer.repository.joke.JokeRepositoryImpl
import com.tobiapplications.kmpmeetup.datalayer.repository.platform.PlatformRepository
import com.tobiapplications.kmpmeetup.datalayer.repository.platform.PlatformRepositoryImpl
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetJokeUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetJokesUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetNameUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.GetPlatformUseCase
import com.tobiapplications.kmpmeetup.domainlayer.usecase.StoreNameUseCase
import org.koin.dsl.module

object KoinShared {
    private val networkModule = module {
        single<HttpLoggerProvider> {
            HttpLoggerProviderImpl()
        }
        single<HttpClientProvider> {
            HttpClientProviderImpl(
                httpLoggerProvider = get()
            )
        }
        single<JokeNetworkDatasource> {
            JokeNetworkDatasourceImpl(
                httpClientProvider = get()
            )
        }
    }

    private val databaseModule = module {
        single {
            get<KMPDatabase>().roomDao()
        }
        single<LocalDatasource> {
            LocalDatasourceImpl(
                roomDao = get()
            )
        }
    }

    private val dataModule = module {
        single<JokeRepository> {
            JokeRepositoryImpl(
                jokeNetworkDatasource = get()
            )
        }
        single<PlatformRepository> {
            PlatformRepositoryImpl(
                platform = get()
            )
        }
        single<DatabaseRepository> {
            DatabaseRepositoryImpl(
                localDatasource = get()
            )
        }
    }

    private val domainModule = module {
        factory {
            GetJokeUseCase(
                jokeRepository = get()
            )
        }
        factory {
            GetJokesUseCase(
                jokeRepository = get()
            )
        }
        factory {
            GetPlatformUseCase(
                platformRepository = get()
            )
        }
        factory {
            StoreNameUseCase(
                databaseRepository = get()
            )
        }
        factory {
            GetNameUseCase(
                databaseRepository = get()
            )
        }
    }

    val sharedModules = listOf(
        platformModule,
        networkModule,
        databaseModule,
        dataModule,
        domainModule
    )
}

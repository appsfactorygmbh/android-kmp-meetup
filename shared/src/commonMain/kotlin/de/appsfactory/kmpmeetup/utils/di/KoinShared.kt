package de.appsfactory.kmpmeetup.utils.di

import de.appsfactory.kmpmeetup.datalayer.datasource.local.LocalDatasource
import de.appsfactory.kmpmeetup.datalayer.datasource.local.LocalDatasourceImpl
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.database.KMPDatabase
import de.appsfactory.kmpmeetup.datalayer.datasource.remote.JokeNetworkDatasource
import de.appsfactory.kmpmeetup.datalayer.datasource.remote.JokeNetworkDatasourceImpl
import de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.client.HttpClientProvider
import de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.client.HttpClientProviderImpl
import de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.logger.HttpLoggerProvider
import de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.logger.HttpLoggerProviderImpl
import de.appsfactory.kmpmeetup.datalayer.repository.database.DatabaseRepository
import de.appsfactory.kmpmeetup.datalayer.repository.database.DatabaseRepositoryImpl
import de.appsfactory.kmpmeetup.datalayer.repository.joke.JokeRepository
import de.appsfactory.kmpmeetup.datalayer.repository.joke.JokeRepositoryImpl
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetJokeUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetJokesUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.GetUserNameUseCase
import de.appsfactory.kmpmeetup.domainlayer.usecase.StoreUserNameUseCase
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
            StoreUserNameUseCase(
                databaseRepository = get()
            )
        }
        factory {
            GetUserNameUseCase(
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

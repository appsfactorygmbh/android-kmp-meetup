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
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object KoinShared {
    private val networkModule = module {
        singleOf(::HttpLoggerProviderImpl) bind HttpLoggerProvider::class
        singleOf(::HttpClientProviderImpl) bind HttpClientProvider::class
        singleOf(::JokeNetworkDatasourceImpl) bind JokeNetworkDatasource::class
    }

    private val databaseModule = module {
        single { get<KMPDatabase>().roomDao() }
        singleOf(::LocalDatasourceImpl) bind LocalDatasource::class
    }

    private val dataModule = module {
        singleOf(::JokeRepositoryImpl) bind JokeRepository::class
        singleOf(::DatabaseRepositoryImpl) bind DatabaseRepository::class
    }

    private val domainModule = module {
        factoryOf(::GetJokeUseCase)
        factoryOf(::GetJokesUseCase)
        factoryOf(::StoreUserNameUseCase)
        factoryOf(::GetUserNameUseCase)
    }

    val sharedModules = listOf(
        platformModule,
        networkModule,
        databaseModule,
        dataModule,
        domainModule
    )
}

package com.tobiapplications.kmpmeetup.datalayer.repository.database

import com.tobiapplications.kmpmeetup.datalayer.datasource.local.LocalDatasource
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

class DatabaseRepositoryImpl(
    private val localDatasource: LocalDatasource
) : DatabaseRepository {

    override suspend fun storeName(name: Name) {
        localDatasource.insertName(name)
    }

    override fun getName(): Flow<Name> {
        return localDatasource.getName()
    }
}
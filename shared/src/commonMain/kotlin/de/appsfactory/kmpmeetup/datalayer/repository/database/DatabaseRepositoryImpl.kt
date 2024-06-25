package de.appsfactory.kmpmeetup.datalayer.repository.database

import de.appsfactory.kmpmeetup.datalayer.datasource.local.LocalDatasource
import de.appsfactory.kmpmeetup.domainlayer.model.UserName
import kotlinx.coroutines.flow.Flow

class DatabaseRepositoryImpl(
    private val localDatasource: LocalDatasource
) : DatabaseRepository {

    override suspend fun storeUserName(userName: UserName): Boolean {
       return localDatasource.insertUserName(userName)
    }

    override fun getUserName(): Flow<UserName> {
        return localDatasource.getUserName()
    }
}
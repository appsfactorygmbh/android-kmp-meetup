package de.appsfactory.kmpmeetup.datalayer.datasource.local

import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.dao.RoomDao
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.mapper.toDbData
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.mapper.toEntity
import de.appsfactory.kmpmeetup.domainlayer.model.UserName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

internal class LocalDatasourceImpl(
    private val roomDao: RoomDao
) : LocalDatasource {

    override suspend fun insertUserName(userName: UserName): Boolean {
        roomDao.insertUserName(userName.toDbData())
        return true
    }

    override fun getUserName(): Flow<UserName> {
        return roomDao.getUserName().mapNotNull {
            it?.toEntity()
        }
    }
}
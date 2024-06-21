package com.tobiapplications.kmpmeetup.datalayer.datasource.local

import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.dao.RoomDao
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.mapper.toDbData
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.mapper.toEntity
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class LocalDatasourceImpl(
    private val roomDao: RoomDao
) : LocalDatasource {

    override suspend fun insertName(name: Name) {
        roomDao.insertModel(name.toDbData())
    }

    override fun getName(): Flow<Name> {
        return roomDao.getModel().mapNotNull {
            it?.toEntity()
        }
    }
}
package com.tobiapplications.kmpmeetup.datalayer.repository.database

import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    suspend fun storeName(name: Name)

    fun getName() : Flow<Name>
}
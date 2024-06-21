package com.tobiapplications.kmpmeetup.datalayer.datasource.local

import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

interface LocalDatasource {

    suspend fun insertName(name: Name)

    fun getName() : Flow<Name>
}
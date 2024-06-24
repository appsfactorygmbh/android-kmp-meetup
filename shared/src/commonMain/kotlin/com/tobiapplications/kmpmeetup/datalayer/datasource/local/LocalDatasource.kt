package com.tobiapplications.kmpmeetup.datalayer.datasource.local

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

interface LocalDatasource {

    @NativeCoroutines
    suspend fun insertName(name: Name)

    @NativeCoroutines
    fun getName() : Flow<Name>
}
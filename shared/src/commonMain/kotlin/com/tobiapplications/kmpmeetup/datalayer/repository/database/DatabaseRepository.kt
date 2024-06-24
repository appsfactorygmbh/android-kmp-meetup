package com.tobiapplications.kmpmeetup.datalayer.repository.database

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    @NativeCoroutines
    suspend fun storeName(name: Name)

    @NativeCoroutines
    fun getName() : Flow<Name>
}
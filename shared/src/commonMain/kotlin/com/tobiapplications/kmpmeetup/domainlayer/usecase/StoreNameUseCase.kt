package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.datalayer.repository.database.DatabaseRepository
import com.tobiapplications.kmpmeetup.domainlayer.model.Name

class StoreNameUseCase(
    private val databaseRepository: DatabaseRepository
) {

    @NativeCoroutines
    suspend fun invoke(name: Name) {
        databaseRepository.storeName(name)
    }
}
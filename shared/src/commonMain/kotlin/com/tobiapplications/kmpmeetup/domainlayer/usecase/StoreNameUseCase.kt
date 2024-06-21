package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.tobiapplications.kmpmeetup.datalayer.repository.database.DatabaseRepository
import com.tobiapplications.kmpmeetup.domainlayer.model.Name

class StoreNameUseCase(
    private val databaseRepository: DatabaseRepository
) {

    suspend fun invoke(name: Name) {
        databaseRepository.storeName(name)
    }
}
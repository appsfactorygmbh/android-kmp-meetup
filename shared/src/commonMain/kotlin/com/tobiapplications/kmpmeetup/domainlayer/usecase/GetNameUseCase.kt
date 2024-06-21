package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.tobiapplications.kmpmeetup.datalayer.repository.database.DatabaseRepository
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

class GetNameUseCase(
    private val databaseRepository: DatabaseRepository
) {

    fun invoke() : Flow<Name> {
        return databaseRepository.getName()
    }
}
package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.datalayer.repository.database.DatabaseRepository
import com.tobiapplications.kmpmeetup.domainlayer.model.Name
import kotlinx.coroutines.flow.Flow

class GetNameUseCase(
    private val databaseRepository: DatabaseRepository
) {

    @NativeCoroutines
    fun invoke() : Flow<Name> {
        return databaseRepository.getName()
    }
}
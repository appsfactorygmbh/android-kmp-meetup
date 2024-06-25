package de.appsfactory.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.datalayer.repository.database.DatabaseRepository
import de.appsfactory.kmpmeetup.domainlayer.model.UserName
import kotlinx.coroutines.flow.Flow

class GetUserNameUseCase(
    private val databaseRepository: DatabaseRepository
) {

    @NativeCoroutines
    fun invoke() : Flow<UserName> {
        return databaseRepository.getUserName()
    }
}
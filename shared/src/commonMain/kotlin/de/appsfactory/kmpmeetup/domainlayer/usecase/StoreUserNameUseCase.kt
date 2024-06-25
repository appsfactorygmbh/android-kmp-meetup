package de.appsfactory.kmpmeetup.domainlayer.usecase

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.datalayer.repository.database.DatabaseRepository
import de.appsfactory.kmpmeetup.domainlayer.model.UserName

class StoreUserNameUseCase(
    private val databaseRepository: DatabaseRepository
) {

    @NativeCoroutines
    suspend fun invoke(userName: UserName): Boolean {
        return databaseRepository.storeUserName(userName)
    }
}
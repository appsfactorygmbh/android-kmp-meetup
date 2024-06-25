package de.appsfactory.kmpmeetup.datalayer.repository.database

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.domainlayer.model.UserName
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    @NativeCoroutines
    suspend fun storeUserName(userName: UserName): Boolean

    @NativeCoroutines
    fun getUserName() : Flow<UserName>
}
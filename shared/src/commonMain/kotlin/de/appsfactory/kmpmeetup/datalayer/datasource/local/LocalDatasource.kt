package de.appsfactory.kmpmeetup.datalayer.datasource.local

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.domainlayer.model.UserName
import kotlinx.coroutines.flow.Flow

interface LocalDatasource {

    @NativeCoroutines
    suspend fun insertUserName(userName: UserName): Boolean

    @NativeCoroutines
    fun getUserName(): Flow<UserName>
}
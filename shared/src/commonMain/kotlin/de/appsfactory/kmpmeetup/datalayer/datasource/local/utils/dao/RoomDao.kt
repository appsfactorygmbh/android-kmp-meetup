package de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.model.DbUserName
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @NativeCoroutines
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserName(dbUserName: DbUserName): Long?

    @NativeCoroutines
    @Query("SELECT * FROM DbUserName")
    fun getUserName(): Flow<DbUserName?>
}
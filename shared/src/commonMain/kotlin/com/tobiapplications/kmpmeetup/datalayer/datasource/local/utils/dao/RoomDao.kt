package com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.model.DbName
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @NativeCoroutines
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModel(dbName: DbName)

    @NativeCoroutines
    @Query("SELECT * FROM DbName")
    fun getModel(): Flow<DbName?>
}
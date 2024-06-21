package com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.dao.RoomDao
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.model.DbName

@Database(
    entities = [DbName::class],
    version = 1
)
abstract class KMPDatabase : RoomDatabase(){

    abstract fun roomDao() : RoomDao

}

val kmpDatabaseName = "kmpdatabase"

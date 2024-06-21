package com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.dao.RoomDao
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.model.DbName

@Database(
    entities = [DbName::class],
    version = 1
)
abstract class KMPDatabase : RoomDatabase(), DB {

    abstract fun roomDao(): RoomDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// Added a hack to resolve below issue:
// Class 'KMPDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DB {
    fun clearAllTables() {}
}

val kmpDatabaseName = "kmpdatabase"

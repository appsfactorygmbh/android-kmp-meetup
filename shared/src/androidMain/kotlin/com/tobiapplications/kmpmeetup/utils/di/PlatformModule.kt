package com.tobiapplications.kmpmeetup.utils.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.database.KMPDatabase
import com.tobiapplications.kmpmeetup.datalayer.datasource.local.utils.database.kmpDatabaseName
import com.tobiapplications.kmpmeetup.utils.AndroidPlatform
import com.tobiapplications.kmpmeetup.utils.Platform
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<Platform> { AndroidPlatform() }
    single<KMPDatabase> { createKMPDatabase(get()) }
}

fun createKMPDatabase(context: Context): KMPDatabase {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(kmpDatabaseName)
    return Room.databaseBuilder<KMPDatabase>(appContext, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

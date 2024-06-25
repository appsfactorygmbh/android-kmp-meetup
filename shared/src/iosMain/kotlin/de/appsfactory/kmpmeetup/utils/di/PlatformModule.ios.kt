package de.appsfactory.kmpmeetup.utils.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.database.KMPDatabase
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.database.instantiateImpl
import de.appsfactory.kmpmeetup.datalayer.datasource.local.utils.database.kmpDatabaseName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

actual val platformModule: Module = module {
    single<KMPDatabase> { createKMPDatabase() }
}

fun createKMPDatabase(): KMPDatabase {
    val dbFile = "${fileDirectory()}/$kmpDatabaseName"
    return Room.databaseBuilder<KMPDatabase>(
        name = dbFile,
        factory =  { KMPDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

private fun fileDirectory(): String {
    val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory).path!!
}
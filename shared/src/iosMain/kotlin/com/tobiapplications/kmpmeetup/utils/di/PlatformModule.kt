package com.tobiapplications.kmpmeetup.utils.di

import com.tobiapplications.kmpmeetup.utils.IOSPlatform
import com.tobiapplications.kmpmeetup.utils.Platform
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

actual val platformModule: Module = module {
    single<Platform> { IOSPlatform() }
//    single<KMPDatabase> { createKMPDatabase() }
}

//fun createKMPDatabase(): KMPDatabase {
//    val dbFile = "${fileDirectory()}/$kmpDatabaseName"
//    return Room.databaseBuilder<KMPDatabase>(
//        name = dbFile,
//        factory =  { KMPDatabase::class.instantiateImpl() }
//    ).setDriver(BundledSQLiteDriver())
//        .setQueryCoroutineContext(Dispatchers.IO)
//        .build()
//}

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
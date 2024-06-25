package de.appsfactory.kmpmeetup.android

import android.app.Application
import de.appsfactory.kmpmeetup.android.di.KoinAndroid
import de.appsfactory.kmpmeetup.utils.di.KoinShared
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KMPApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@KMPApp)
            androidLogger()
            modules(KoinShared.sharedModules + KoinAndroid.viewModelModule)
        }
    }
}
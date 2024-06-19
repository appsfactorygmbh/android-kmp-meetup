package com.tobiapplications.kmpmeetup.android

import android.app.Application
import com.tobiapplications.kmpmeetup.android.di.KoinAndroid
import com.tobiapplications.kmpmeetup.di.KoinShared
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
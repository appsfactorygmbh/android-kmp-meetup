package de.appsfactory.kmpmeetup.android.di

import de.appsfactory.kmpmeetup.android.ui.database.DatabaseViewModel
import de.appsfactory.kmpmeetup.android.ui.jokesflow.JokesFlowViewModel
import de.appsfactory.kmpmeetup.uilayer.SingleJokeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object KoinAndroid {

    val viewModelModule = module {
        viewModelOf(::SingleJokeViewModel)
        viewModelOf(::JokesFlowViewModel)
        viewModelOf(::DatabaseViewModel)
    }
}
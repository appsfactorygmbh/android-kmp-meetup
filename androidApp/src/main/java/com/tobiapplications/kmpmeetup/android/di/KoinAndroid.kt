package com.tobiapplications.kmpmeetup.android.di

import com.tobiapplications.kmpmeetup.android.ui.database.DatabaseViewModel
import com.tobiapplications.kmpmeetup.android.ui.jokes.JokesViewModel
import com.tobiapplications.kmpmeetup.uilayer.singlejoke.SingleJokeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinAndroid {

    val viewModelModule = module {
        viewModel {
            SingleJokeViewModel(
                getJokeUseCase = get()
            )
        }
        viewModel {
            JokesViewModel(
                getJokesUseCase = get()
            )
        }
        viewModel {
            DatabaseViewModel(
                storeNameUseCase = get(),
                getNameUseCase = get()
            )
        }
    }
}
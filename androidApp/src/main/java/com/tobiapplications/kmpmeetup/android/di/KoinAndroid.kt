package com.tobiapplications.kmpmeetup.android.di

import com.tobiapplications.kmpmeetup.android.ui.database.DatabaseViewModel
import com.tobiapplications.kmpmeetup.android.ui.jokes.JokesViewModel
import com.tobiapplications.kmpmeetup.uilayer.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinAndroid {

    val viewModelModule = module {
        viewModel {
            OverviewViewModel(
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
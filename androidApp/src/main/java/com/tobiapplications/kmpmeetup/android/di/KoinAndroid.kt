package com.tobiapplications.kmpmeetup.android.di

import com.tobiapplications.kmpmeetup.android.ui.detail.DetailViewModel
import com.tobiapplications.kmpmeetup.viewmodel.overview.OverviewViewModel
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
            DetailViewModel(
                getJokesUseCase = get()
            )
        }
    }
}
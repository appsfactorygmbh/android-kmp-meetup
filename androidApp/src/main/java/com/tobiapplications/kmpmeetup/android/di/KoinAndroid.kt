package com.tobiapplications.kmpmeetup.android.di

import com.tobiapplications.kmpmeetup.viewmodel.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinAndroid {

    val viewModelModule = module {
        viewModel {
            MainViewModel(
                getJokeUseCase = get()
            )
        }
    }
}
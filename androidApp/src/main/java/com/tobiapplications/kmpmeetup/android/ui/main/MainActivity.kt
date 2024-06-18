package com.tobiapplications.kmpmeetup.android.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme
import com.tobiapplications.kmpmeetup.viewmodel.main.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainUiState by viewModel.menuUiState.collectAsState()
            KMPTheme(
                content = {
                    MainContent(
                        mainUiState = mainUiState,
                        onRequestJokeClicked = {
                            viewModel.requestJoke()
                        }
                    )
                }
            )
        }
    }
}


package com.tobiapplications.kmpmeetup.android.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tobiapplications.kmpmeetup.Greeting
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme
import com.tobiapplications.kmpmeetup.android.utils.ThemePreviews
import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.viewmodel.main.MainUiState


@Composable
fun MainScreen(
    mainUiState: MainUiState,
    onRequestJokeClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Joke App")
                }
            )
        },
        modifier = Modifier
    ) { paddingValues ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(Greeting().greet())
                Button(
                    onClick = onRequestJokeClicked,
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text(text = "Request Joke", color = Color.White)
                }
                MainContent(
                    mainUiState = mainUiState,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
            }
        }
    }
}

@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        MainScreen(
            mainUiState = MainUiState.Data(
                jokeResponse = JokeResponse(
                    question = "Joke question",
                    answer = "Joke answer",
                    joke = ""
                )
            ),
            onRequestJokeClicked = {}
        )
    }
}
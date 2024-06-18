package com.tobiapplications.kmpmeetup.android.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tobiapplications.kmpmeetup.Greeting
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme
import com.tobiapplications.kmpmeetup.android.utils.ThemePreviews
import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.viewmodel.main.MainUiState


@Composable
fun MainContent(
    mainUiState: MainUiState,
    onRequestJokeClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Joke App")
            })
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
                    .padding(all = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GreetingView(Greeting().greet())
                Spacer(modifier = Modifier.padding(top = 64.dp))
                Button(
                    onClick = onRequestJokeClicked
                ) {
                    Text(text = "Request Joke", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(top = 16.dp))
                when (mainUiState) {
                    is MainUiState.Idle -> JokeExplanation()
                    is MainUiState.Loading -> CircularProgressIndicator()
                    is MainUiState.Data -> Joke(jokeResponse = mainUiState.jokeResponse)
                }
            }
        }
    }
}

@Composable
private fun GreetingView(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(text = text, modifier = modifier)
}

@Composable
private fun JokeExplanation(modifier: Modifier = Modifier) {
    Text(
        text = "Press the button and laugh :)",
        modifier = modifier
    )
}

@Composable
fun Joke(
    jokeResponse: JokeResponse,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (jokeResponse.joke.isNotEmpty()) {
            Text(
                text = jokeResponse.joke,
                textAlign = TextAlign.Center
            )
        } else if (jokeResponse.question.isNotEmpty() && jokeResponse.answer.isNotEmpty()) {
            Text(
                text = jokeResponse.question,
                textAlign = TextAlign.Center
            )
            Text(
                text = jokeResponse.answer,
                textAlign = TextAlign.Center
            )
        } else {
            Text(text = "Joke data invalid $jokeResponse")
        }
    }
}

@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        MainContent(
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
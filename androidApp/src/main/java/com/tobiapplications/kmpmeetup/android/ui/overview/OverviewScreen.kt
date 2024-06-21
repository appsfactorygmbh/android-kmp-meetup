package com.tobiapplications.kmpmeetup.android.ui.overview

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
import androidx.compose.ui.unit.dp
import com.tobiapplications.kmpmeetup.utils.Greeting
import com.tobiapplications.kmpmeetup.android.ui.composables.JokeText
import com.tobiapplications.kmpmeetup.android.ui.main.Database
import com.tobiapplications.kmpmeetup.android.ui.main.Jokes
import com.tobiapplications.kmpmeetup.android.ui.main.Screen
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme
import com.tobiapplications.kmpmeetup.android.utils.ThemePreviews
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke
import com.tobiapplications.kmpmeetup.uilayer.overview.JokeUiState


@Composable
fun OverviewScreen(
    jokeUiState: JokeUiState,
    onRequestJokeClicked: () -> Unit,
    onOpenScreen: (Screen) -> Unit
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
                Spacer(modifier = Modifier.weight(1f))
                JokeView(jokeUiState = jokeUiState)
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        onOpenScreen(Jokes)
                    }
                ) {
                    Text(text = "Open Jokes", color = Color.White)
                }
                Button(
                    onClick = {
                        onOpenScreen(Database)
                    }
                ) {
                    Text(text = "Open Database Example", color = Color.White)
                }
            }
        }
    }
}

@Composable
private fun JokeView(jokeUiState: JokeUiState) {
    when (jokeUiState) {
        is JokeUiState.Idle -> Text(text = "Press the button and laugh :)")
        is JokeUiState.Loading -> CircularProgressIndicator()
        is JokeUiState.Data -> JokeText(
            joke = jokeUiState.joke
        )
    }
}

@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        OverviewScreen(
            jokeUiState = JokeUiState.Data(
                joke = Joke(
                    question = "Joke question",
                    answer = "Joke answer",
                    jokeText = ""
                )
            ),
            onRequestJokeClicked = {},
            onOpenScreen = { _ ->}
        )
    }
}
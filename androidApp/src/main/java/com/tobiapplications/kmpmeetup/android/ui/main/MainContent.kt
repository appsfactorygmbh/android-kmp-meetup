package com.tobiapplications.kmpmeetup.android.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.viewmodel.main.MainUiState

@Composable
fun MainContent(
    mainUiState: MainUiState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight(fraction = 0.5f),
        contentAlignment = Alignment.Center,
    ) {
        when (mainUiState) {
            is MainUiState.Idle -> JokeExplanation()
            is MainUiState.Loading -> CircularProgressIndicator()
            is MainUiState.Data -> JokeText(jokeResponse = mainUiState.jokeResponse)
        }
    }
}


@Composable
private fun JokeExplanation(modifier: Modifier = Modifier) {
    Text(
        text = "Press the button and laugh :)",
        modifier = modifier
    )
}

@Composable
fun JokeText(
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
        }
    }
}

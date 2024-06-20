package com.tobiapplications.kmpmeetup.android.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.tobiapplications.kmpmeetup.model.JokeResponse

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
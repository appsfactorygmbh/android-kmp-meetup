package de.appsfactory.kmpmeetup.android.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import de.appsfactory.kmpmeetup.domainlayer.model.Joke

@Composable
fun JokeText(
    joke: Joke,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (joke.jokeText.isNotEmpty()) {
            Text(
                text = joke.jokeText,
                textAlign = TextAlign.Center
            )
        } else if (joke.question.isNotEmpty() && joke.answer.isNotEmpty()) {
            Text(
                text = joke.question,
                textAlign = TextAlign.Center
            )
            Text(
                text = joke.answer,
                textAlign = TextAlign.Center
            )
        }
    }
}
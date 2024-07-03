package de.appsfactory.kmpmeetup.android.ui.jokesflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.appsfactory.kmpmeetup.android.ui.composables.JokeText
import de.appsfactory.kmpmeetup.android.ui.composables.KMPAppBar
import de.appsfactory.kmpmeetup.android.utils.KMPTheme
import de.appsfactory.kmpmeetup.android.utils.ThemePreviews
import de.appsfactory.kmpmeetup.domainlayer.model.Joke

@Composable
fun JokesFlowScreen(
    jokesFlowUiState: JokesFlowUiState,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            KMPAppBar(
                text = "Jokes",
                onBackButtonClicked = onNavigateBack
            )
        },
        modifier = Modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (jokesFlowUiState) {
                is JokesFlowUiState.Loading -> CircularProgressIndicator()
                is JokesFlowUiState.Data -> {
                    JokeText(joke = jokesFlowUiState.joke)
                }
            }
        }
    }
}


@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        JokesFlowScreen(
            jokesFlowUiState = JokesFlowUiState.Data(
                joke = Joke(
                    question = "",
                    answer = "",
                    jokeText = "Joke"
                )
            ),
            onNavigateBack = {}
        )
    }
}
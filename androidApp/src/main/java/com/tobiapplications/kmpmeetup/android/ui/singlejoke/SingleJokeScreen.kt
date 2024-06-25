package com.tobiapplications.kmpmeetup.android.ui.singlejoke

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tobiapplications.kmpmeetup.android.ui.composables.JokeText
import com.tobiapplications.kmpmeetup.android.ui.composables.KMPAppBar
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme
import com.tobiapplications.kmpmeetup.android.utils.ThemePreviews
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke
import com.tobiapplications.kmpmeetup.uilayer.SingleJokeUiState

@Composable
fun SingleJokeScreen(
    singleJokeUiState: SingleJokeUiState,
    onRequestJokeClicked: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            KMPAppBar(
                text = "Single joke",
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
            Spacer(modifier = Modifier.weight(1f))
            JokeView(singleJokeUiState = singleJokeUiState)
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onRequestJokeClicked,
                enabled = singleJokeUiState !is SingleJokeUiState.Loading,
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text(text = "Request Joke")
            }
        }
    }
}

@Composable
private fun JokeView(singleJokeUiState: SingleJokeUiState) {
    when (singleJokeUiState) {
        is SingleJokeUiState.Idle -> Text(text = "Press the button and laugh :)")
        is SingleJokeUiState.Loading -> CircularProgressIndicator()
        is SingleJokeUiState.Data -> JokeText(
            joke = singleJokeUiState.joke
        )
    }
}


@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        SingleJokeScreen(
            singleJokeUiState = SingleJokeUiState.Data(
                joke = Joke(
                    question = "",
                    answer = "",
                    jokeText = "Joke"
                )
            ),
            onRequestJokeClicked = {},
            onNavigateBack = {}
        )
    }
}
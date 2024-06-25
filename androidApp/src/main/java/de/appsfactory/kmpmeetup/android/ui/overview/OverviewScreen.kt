package de.appsfactory.kmpmeetup.android.ui.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.appsfactory.kmpmeetup.android.ui.composables.KMPAppBar
import de.appsfactory.kmpmeetup.android.ui.main.Screen
import de.appsfactory.kmpmeetup.android.utils.KMPTheme
import de.appsfactory.kmpmeetup.android.utils.ThemePreviews
import de.appsfactory.kmpmeetup.utils.Greeting


@Composable
fun OverviewScreen(
    onOpenScreen: (Screen) -> Unit
) {
    Scaffold(
        topBar = { KMPAppBar(text = "Joke App") },
        modifier = Modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(Greeting().greet())
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onOpenScreen(Screen.SingleJoke)
                }
            ) {
                Text(text = "Open single joke")
            }
            Button(
                onClick = { onOpenScreen(Screen.Jokes)
                }
            ) {
                Text(text = "Open jokes flow")
            }
            Button(
                onClick = {
                    onOpenScreen(Screen.Database)
                }
            ) {
                Text(text = "Open Database Example")
            }
        }
    }
}

@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        OverviewScreen(
            onOpenScreen = { _ -> }
        )
    }
}
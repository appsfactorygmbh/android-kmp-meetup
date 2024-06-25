package de.appsfactory.kmpmeetup.android.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.appsfactory.kmpmeetup.android.utils.KMPTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMPTheme {
                MainNavHost()
            }
        }
    }
}


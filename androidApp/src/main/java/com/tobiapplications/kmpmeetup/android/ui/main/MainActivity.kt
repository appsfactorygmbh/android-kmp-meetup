package com.tobiapplications.kmpmeetup.android.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMPTheme {
                MainRoute()
            }
        }
    }
}


package com.tobiapplications.kmpmeetup.android.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun KMPAppBar(
    text: String,
    onBackButtonClicked: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = text)
        },
        navigationIcon = {
            onBackButtonClicked?.let {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}
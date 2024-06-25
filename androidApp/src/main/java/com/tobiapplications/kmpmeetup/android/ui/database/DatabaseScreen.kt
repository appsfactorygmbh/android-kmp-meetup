package com.tobiapplications.kmpmeetup.android.ui.database

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tobiapplications.kmpmeetup.android.ui.composables.KMPAppBar
import com.tobiapplications.kmpmeetup.android.utils.KMPTheme
import com.tobiapplications.kmpmeetup.android.utils.ThemePreviews

@Composable
fun DatabaseScreen(
    databaseUiState: DatabaseUiState,
    nameStoredSuccessful: Boolean,
    onNavigateBack: () -> Unit,
    onStoreNameClicked: (String) -> Unit,
    onSnackbarDismissed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = {
            KMPAppBar(
                text = "Database",
                onBackButtonClicked = onNavigateBack
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        modifier = modifier
    ) { paddingValues ->
        var name by remember(databaseUiState) {
            mutableStateOf(
                when (databaseUiState) {
                    is DatabaseUiState.Idle -> ""
                    is DatabaseUiState.Data -> databaseUiState.name
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Please enter your name")
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(text = "Your name")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        name = ""
                    }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { onStoreNameClicked(name) },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text(text = "Store your name")
            }
        }
    }

    if (nameStoredSuccessful) {
        LaunchedEffect(key1 = Unit) {
            snackbarHostState.showSnackbar(message = "Name stored successfully")
            onSnackbarDismissed()
        }
    }
}


@ThemePreviews
@Composable
fun DefaultPreview() {
    KMPTheme {
        DatabaseScreen(
            databaseUiState = DatabaseUiState.Data(
                name = "name",
            ),
            nameStoredSuccessful = false,
            onNavigateBack = {},
            onStoreNameClicked = { _ -> },
            onSnackbarDismissed = {}
        )
    }
}
package de.appsfactory.kmpmeetup.android.ui.database

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import de.appsfactory.kmpmeetup.android.ui.composables.KMPAppBar
import de.appsfactory.kmpmeetup.android.utils.KMPTheme
import de.appsfactory.kmpmeetup.android.utils.ThemePreviews

@Composable
fun DatabaseScreen(
    databaseUiState: DatabaseUiState,
    userNameStoredSuccessful: Boolean,
    onNavigateBack: () -> Unit,
    onStoreUserNameClicked: (String) -> Unit,
    onSnackbarDismissed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val snackbarHostState = remember { SnackbarHostState() }
    var userName by remember(databaseUiState) {
        mutableStateOf(
            when (databaseUiState) {
                is DatabaseUiState.Idle -> ""
                is DatabaseUiState.Data -> databaseUiState.userName
            }
        )
    }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Please enter your username")
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = {
                    Text(text = "Your username")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        userName = ""
                    }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    userName = userName.trim()
                    onStoreUserNameClicked(userName)
                },
                modifier = Modifier.padding(top = 16.dp),
            ) {
                Text(text = "Store your username")
            }
        }
    }

    if (userNameStoredSuccessful) {
        LaunchedEffect(key1 = Unit) {
            val successMessage = if (userName.isEmpty()) {
                "Username cleared successfully"
            } else {
                "Username ($userName) stored successfully"
            }
            snackbarHostState.showSnackbar(message = successMessage)
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
                userName = "name",
            ),
            userNameStoredSuccessful = false,
            onNavigateBack = {},
            onStoreUserNameClicked = { _ -> },
            onSnackbarDismissed = {}
        )
    }
}
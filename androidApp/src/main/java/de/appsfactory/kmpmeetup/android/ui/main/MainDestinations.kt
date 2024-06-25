package de.appsfactory.kmpmeetup.android.ui.main

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {

    @Serializable
    data object Overview : Screen

    @Serializable
    data object SingleJoke : Screen

    @Serializable
    data object Jokes : Screen

    @Serializable
    data object Database : Screen
}

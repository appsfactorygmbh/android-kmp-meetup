package com.tobiapplications.kmpmeetup.android.ui.main

import kotlinx.serialization.Serializable


interface Screen

@Serializable
data object Overview : Screen

@Serializable
data object Jokes : Screen

@Serializable
data object Database : Screen


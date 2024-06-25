package de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiJoke(
    @SerialName(value = "setup") val question: String?,
    @SerialName(value = "delivery") val answer: String?,
    @SerialName(value = "joke") val jokeText: String?
)

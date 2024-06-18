package com.tobiapplications.kmpmeetup.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiJokeResponse(
    @SerialName(value = "setup") val question: String?,
    @SerialName(value = "delivery") val answer: String?,
    @SerialName(value = "joke") val joke: String?
)

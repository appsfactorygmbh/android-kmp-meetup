package com.tobiapplications.kmpmeetup.network.mapper

import com.tobiapplications.kmpmeetup.model.JokeResponse
import com.tobiapplications.kmpmeetup.network.model.ApiJokeResponse

fun ApiJokeResponse.mapToEntity() = JokeResponse(
    question = question ?: "",
    answer = answer ?: "",
    joke = joke ?: ""
)
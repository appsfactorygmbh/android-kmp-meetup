package com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.mapper

import com.tobiapplications.kmpmeetup.datalayer.datasource.remote.utils.model.ApiJoke
import com.tobiapplications.kmpmeetup.domainlayer.model.Joke

fun ApiJoke.mapToEntity() = Joke(
    question = question ?: "",
    answer = answer ?: "",
    jokeText = jokeText ?: ""
)
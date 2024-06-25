package de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.mapper

import de.appsfactory.kmpmeetup.datalayer.datasource.remote.utils.model.ApiJoke
import de.appsfactory.kmpmeetup.domainlayer.model.Joke

fun ApiJoke.mapToEntity() = Joke(
    question = question ?: "",
    answer = answer ?: "",
    jokeText = jokeText ?: ""
)
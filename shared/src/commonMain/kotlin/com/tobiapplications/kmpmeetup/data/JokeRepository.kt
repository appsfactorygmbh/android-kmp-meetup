package com.tobiapplications.kmpmeetup.data

import com.tobiapplications.kmpmeetup.model.JokeResponse

interface JokeRepository {

    suspend fun getJoke() : JokeResponse
}
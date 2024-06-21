package com.tobiapplications.kmpmeetup.utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
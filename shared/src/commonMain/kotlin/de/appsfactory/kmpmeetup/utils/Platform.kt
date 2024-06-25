package de.appsfactory.kmpmeetup.utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
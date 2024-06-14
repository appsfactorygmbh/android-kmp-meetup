package com.tobiapplications.kmpmeetup

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
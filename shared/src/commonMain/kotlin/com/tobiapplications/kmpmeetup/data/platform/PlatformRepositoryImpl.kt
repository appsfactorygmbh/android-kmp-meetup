package com.tobiapplications.kmpmeetup.data.platform

import com.tobiapplications.kmpmeetup.Platform

class PlatformRepositoryImpl(
    private val platform: Platform
): PlatformRepository {

    override fun getPlatformName() : String{
        return platform.name
    }
}
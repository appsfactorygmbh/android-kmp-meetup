package com.tobiapplications.kmpmeetup.datalayer.repository.platform

import com.tobiapplications.kmpmeetup.utils.Platform

class PlatformRepositoryImpl(
    private val platform: Platform
): PlatformRepository {

    override fun getPlatformName() : String{
        return platform.name
    }
}
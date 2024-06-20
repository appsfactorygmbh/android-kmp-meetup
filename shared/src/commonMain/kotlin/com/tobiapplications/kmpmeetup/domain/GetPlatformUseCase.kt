package com.tobiapplications.kmpmeetup.domain

import com.tobiapplications.kmpmeetup.data.platform.PlatformRepository

class GetPlatformUseCase(
    private val platformRepository: PlatformRepository
) {

    fun invoke() : String {
        return platformRepository.getPlatformName()
    }
}
package com.tobiapplications.kmpmeetup.domainlayer.usecase

import com.tobiapplications.kmpmeetup.datalayer.repository.platform.PlatformRepository

class GetPlatformUseCase(
    private val platformRepository: PlatformRepository
) {

    fun invoke() : String {
        return platformRepository.getPlatformName()
    }
}
package com.example.domain.use_cases

import com.example.domain.repository.TradeRepository
import javax.inject.Inject

class GetLatestUseCase @Inject constructor(
    private val tradeRepository: TradeRepository
) {
    operator fun invoke(
        genericError: String
    ) = tradeRepository.getLatest(genericError = genericError)
}
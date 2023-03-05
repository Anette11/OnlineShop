package com.example.domain.use_cases

import com.example.domain.repository.TradeRepository
import javax.inject.Inject

class GetFlashSaleUseCase @Inject constructor(
    private val tradeRepository: TradeRepository
) {
    suspend operator fun invoke() = tradeRepository.getFlashSale()
}
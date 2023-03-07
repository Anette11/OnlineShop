package com.example.domain.use_cases

import com.example.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(
        genericError: String
    ) = productRepository.getProductDetails(genericError = genericError)
}
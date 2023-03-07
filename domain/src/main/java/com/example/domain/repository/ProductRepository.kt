package com.example.domain.repository

import com.example.domain.data.remote.ProductDetails
import com.example.domain.util.ApiResponse
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProductDetails(
        genericError: String
    ): Flow<ApiResponse<ProductDetails>>
}
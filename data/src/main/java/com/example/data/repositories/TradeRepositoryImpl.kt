package com.example.data.repositories

import com.example.data.remote.ApiService
import com.example.data.remote.toFlashSale
import com.example.data.remote.toLatest
import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest
import com.example.domain.repository.TradeRepository
import com.example.domain.util.ApiResponse
import javax.inject.Inject

class TradeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TradeRepository {

    override suspend fun getLatest(): ApiResponse<List<Latest>> {
        return try {
            val data = apiService.getLatest().data?.latest?.map { latestDto ->
                latestDto.toLatest()
            }
            ApiResponse.Success(data = data ?: emptyList())
        } catch (e: Exception) {
            ApiResponse.Error(message = e.localizedMessage)
        }
    }

    override suspend fun getFlashSale(): ApiResponse<List<FlashSale>> =
        try {
            val data = apiService.getFlashSale().data?.flashSale?.map { flashSaleDto ->
                flashSaleDto.toFlashSale()
            }
            ApiResponse.Success(data = data ?: emptyList())
        } catch (e: Exception) {
            ApiResponse.Error(message = e.localizedMessage)
        }
}
package com.example.data.repositories

import com.example.data.BuildConfig
import com.example.data.remote.ApiService
import com.example.data.remote.toFlashSale
import com.example.data.remote.toLatest
import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest
import com.example.domain.repository.TradeRepository
import com.example.domain.util.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TradeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TradeRepository {

    override fun getLatest(
        genericError: String
    ): Flow<ApiResponse<List<Latest>>> = flow {
        try {
            val response = apiService.getLatest()
            if (response.isSuccessful.not() || response.body() == null) {
                emit(ApiResponse.Error(message = genericError))
                return@flow
            }
            val data = response.body()?.latest?.map { latestDto ->
                latestDto.toLatest()
            }
            emit(ApiResponse.Success(data = data ?: emptyList()))
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) e.printStackTrace()
            emit(ApiResponse.Error(message = e.localizedMessage))
        }
    }

    override fun getFlashSale(
        genericError: String
    ): Flow<ApiResponse<List<FlashSale>>> = flow {
        try {
            val response = apiService.getFlashSale()
            if (!response.isSuccessful || response.body() == null) {
                emit(ApiResponse.Error(message = genericError))
                return@flow
            }
            val data = response.body()?.flashSale?.map { flashSaleDto ->
                flashSaleDto.toFlashSale()
            }
            emit(ApiResponse.Success(data = data ?: emptyList()))
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) e.printStackTrace()
            emit(ApiResponse.Error(message = e.localizedMessage))
        }
    }
}
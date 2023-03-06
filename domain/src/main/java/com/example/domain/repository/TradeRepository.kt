package com.example.domain.repository

import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest
import com.example.domain.util.ApiResponse
import kotlinx.coroutines.flow.Flow

interface TradeRepository {

    fun getFlashSale(
        genericError: String
    ): Flow<ApiResponse<List<FlashSale>>>

    fun getLatest(
        genericError: String
    ): Flow<ApiResponse<List<Latest>>>
}
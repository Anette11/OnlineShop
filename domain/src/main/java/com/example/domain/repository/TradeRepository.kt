package com.example.domain.repository

import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest
import com.example.domain.util.ApiResponse

interface TradeRepository {

    suspend fun getFlashSale(): ApiResponse<List<FlashSale>>

    suspend fun getLatest(): ApiResponse<List<Latest>>
}
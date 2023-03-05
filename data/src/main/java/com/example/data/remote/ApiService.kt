package com.example.data.remote

import com.example.data.remote.flash_sale.GetFlashSaleResponse
import com.example.data.remote.latest.GetLatestResponse
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val baseUrl = "https://run.mocky.io/v3/"
    }

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale(): ApiResponse<GetFlashSaleResponse>

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): ApiResponse<GetLatestResponse>
}
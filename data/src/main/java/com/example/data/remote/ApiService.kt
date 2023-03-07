package com.example.data.remote

import com.example.data.remote.flash_sale.GetFlashSaleResponse
import com.example.data.remote.goods_details.ProductDetailsDto
import com.example.data.remote.latest.GetLatestResponse
import com.example.data.remote.words.GetWordsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val baseUrl = "https://run.mocky.io/v3/"
    }

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale(): Response<GetFlashSaleResponse>

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): Response<GetLatestResponse>

    @GET("4c9cd822-9479-4509-803d-63197e5a9e19")
    suspend fun getWords(): Response<GetWordsResponse>

    @GET("f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getProductDetails(): Response<ProductDetailsDto>
}
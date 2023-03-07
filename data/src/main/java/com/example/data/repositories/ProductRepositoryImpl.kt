package com.example.data.repositories

import com.example.data.BuildConfig
import com.example.data.remote.ApiService
import com.example.data.remote.toProductDetails
import com.example.domain.data.remote.ProductDetails
import com.example.domain.repository.ProductRepository
import com.example.domain.util.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository {

    override suspend fun getProductDetails(
        genericError: String
    ): Flow<ApiResponse<ProductDetails>> = flow {
        try {
            val response = apiService.getProductDetails()
            if (response.isSuccessful.not() || response.body() == null) {
                emit(ApiResponse.Error(message = genericError))
                return@flow
            }
            val data = response.body()!!.toProductDetails()
            emit(ApiResponse.Success(data = data))
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) e.printStackTrace()
            emit(ApiResponse.Error(message = e.localizedMessage))
        }
    }
}
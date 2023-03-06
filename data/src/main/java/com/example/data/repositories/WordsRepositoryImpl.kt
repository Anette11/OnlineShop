package com.example.data.repositories

import com.example.data.BuildConfig
import com.example.data.remote.ApiService
import com.example.domain.repository.WordsRepository
import com.example.domain.util.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WordsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WordsRepository {

    override fun getWords(
        genericError: String
    ): Flow<ApiResponse<List<String>>> = flow {
        try {
            val response = apiService.getWords()
            if (response.isSuccessful.not() || response.body() == null) {
                emit(ApiResponse.Error(message = genericError))
                return@flow
            }
            val words = response.body()?.words ?: emptyList()
            emit(ApiResponse.Success(data = words))
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) e.printStackTrace()
            emit(ApiResponse.Error(message = genericError))
        }
    }
}
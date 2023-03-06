package com.example.domain.repository

import com.example.domain.util.ApiResponse
import kotlinx.coroutines.flow.Flow

interface WordsRepository {

    fun getWords(
        genericError: String
    ): Flow<ApiResponse<List<String>>>
}
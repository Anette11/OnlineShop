package com.example.domain.util

sealed class ApiResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(
        data: T
    ) : ApiResponse<T>(
        data = data
    )

    class Error<T>(
        message: String?
    ) : ApiResponse<T>(
        message = message
    )
}
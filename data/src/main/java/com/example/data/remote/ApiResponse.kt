package com.example.data.remote

sealed class ApiResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(
        data: T,
        message: String? = null
    ) : ApiResponse<T>(data)

    class Error<T>(
        message: String?,
        data: T? = null
    ) : ApiResponse<T>(data, message)

    class Loading<T> : ApiResponse<T>()
}
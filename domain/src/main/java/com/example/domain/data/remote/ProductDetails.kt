package com.example.domain.data.remote

data class ProductDetails(
    val colors: List<String> = emptyList(),
    val description: String?,
    val imageUrls: List<String> = emptyList(),
    val name: String?,
    val numberOfReviews: Int?,
    val price: Int?,
    val rating: Double?
)
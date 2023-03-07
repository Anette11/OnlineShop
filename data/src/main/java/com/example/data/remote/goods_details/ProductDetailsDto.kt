package com.example.data.remote.goods_details

import com.google.gson.annotations.SerializedName

data class ProductDetailsDto(
    val colors: List<String> = emptyList(),
    val description: String?,

    @SerializedName(value = "image_urls")
    val imageUrls: List<String> = emptyList(),

    val name: String?,

    @SerializedName(value = "number_of_reviews")
    val numberOfReviews: Int?,

    val price: Int?,
    val rating: Double?
)
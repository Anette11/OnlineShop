package com.example.data.remote.latest

import com.google.gson.annotations.SerializedName

data class LatestDto(
    val category: String?,

    @SerializedName(value = "image_url")
    val imageUrl: String?,

    val name: String?,
    val price: Int?
)
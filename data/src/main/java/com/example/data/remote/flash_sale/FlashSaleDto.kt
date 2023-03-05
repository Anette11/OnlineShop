package com.example.data.remote.flash_sale

import com.google.gson.annotations.SerializedName

data class FlashSaleDto(
    val category: String?,
    val discount: Int?,

    @SerializedName(value = "image_url")
    val imageUrl: String?,

    val name: String?,
    val price: Double?
)
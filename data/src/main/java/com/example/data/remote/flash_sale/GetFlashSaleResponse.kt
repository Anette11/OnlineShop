package com.example.data.remote.flash_sale

import com.google.gson.annotations.SerializedName

data class GetFlashSaleResponse(

    @SerializedName(value = "flash_sale")
    val flashSale: List<FlashSaleDto> = emptyList()
)
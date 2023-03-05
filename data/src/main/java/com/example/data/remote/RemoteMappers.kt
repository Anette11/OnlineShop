package com.example.data.remote

import com.example.data.remote.flash_sale.FlashSaleDto
import com.example.data.remote.latest.LatestDto
import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest

fun LatestDto.toLatest() = Latest(
    category = this.category,
    imageUrl = this.imageUrl,
    name = this.name,
    price = this.price
)

fun FlashSaleDto.toFlashSale() = FlashSale(
    category = this.category,
    discount = this.discount,
    imageUrl = this.imageUrl,
    name = this.name,
    price = this.price
)
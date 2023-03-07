package com.example.data.remote

import com.example.data.remote.flash_sale.FlashSaleDto
import com.example.data.remote.goods_details.ProductDetailsDto
import com.example.data.remote.latest.LatestDto
import com.example.domain.data.remote.FlashSale
import com.example.domain.data.remote.Latest
import com.example.domain.data.remote.ProductDetails

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

fun ProductDetailsDto.toProductDetails() =
    ProductDetails(
        colors = this.colors,
        description = this.description,
        imageUrls = this.imageUrls,
        name = this.name,
        numberOfReviews = this.numberOfReviews,
        price = this.price,
        rating = this.rating
    )
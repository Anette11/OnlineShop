package com.example.data.remote.latest

data class GetLatestResponse(
    val latest: List<LatestDto> = emptyList()
)
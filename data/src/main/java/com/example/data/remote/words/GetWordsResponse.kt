package com.example.data.remote.words

data class GetWordsResponse(
    val words: List<String> = emptyList()
)
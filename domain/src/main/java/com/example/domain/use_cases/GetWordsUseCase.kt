package com.example.domain.use_cases

import com.example.domain.repository.WordsRepository
import javax.inject.Inject

class GetWordsUseCase @Inject constructor(
    private val wordsRepository: WordsRepository
) {
    operator fun invoke(
        genericError: String
    ) = wordsRepository.getWords(genericError = genericError)
}
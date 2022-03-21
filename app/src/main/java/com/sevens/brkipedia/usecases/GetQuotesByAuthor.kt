package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository

class GetQuotesByAuthor (
    private val quoteRepository: IQuoteRepository
) {
    suspend operator fun invoke(author: String): List<DomainQuote> = quoteRepository.getQuotesByAuthor(author)
}
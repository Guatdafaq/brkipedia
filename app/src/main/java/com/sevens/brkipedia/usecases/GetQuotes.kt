package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.data.repositories.QuoteRepository
import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository
import javax.inject.Inject

class GetQuotes @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend operator fun invoke(): List<DomainQuote> = quoteRepository.getAllQuotes()
}
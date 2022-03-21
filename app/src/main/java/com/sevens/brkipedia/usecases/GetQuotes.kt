package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository

class GetQuotes (private val quoteRepository: IQuoteRepository
) {
    suspend operator fun invoke(): List<DomainQuote> = quoteRepository.getAllQuotes()
}
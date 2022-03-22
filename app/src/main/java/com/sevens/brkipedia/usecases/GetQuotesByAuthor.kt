package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository
import javax.inject.Inject

class GetQuotesByAuthor @Inject constructor(
    private val quoteRepository: IQuoteRepository
) {
    suspend operator fun invoke(author: String) : List<DomainQuote> {
        val quotes = quoteRepository.getQuotesByAuthorFromApi(author)
        return if (quotes.isNotEmpty()) {
            quoteRepository.clearQuotes()
            quoteRepository.insertQuotes(quotes)
            quotes
        } else {
            quoteRepository.getQuotesByAuthorFromDatabase(author)
        }
    }
}
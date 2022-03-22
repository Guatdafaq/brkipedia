package com.sevens.brkipedia.domain.repositories

import com.sevens.brkipedia.domain.models.DomainQuote

interface IQuoteRepository {
    suspend fun getAllQuotesFromApi(): List<DomainQuote>
    suspend fun getAllQuotesFromDatabase(): List<DomainQuote>
    suspend fun insertQuotes(quote: List<DomainQuote>)
    suspend fun getQuotesByAuthorFromApi(author: String): List<DomainQuote>
    suspend fun getQuotesByAuthorFromDatabase(author: String): List<DomainQuote>
    suspend fun clearQuotes()
}
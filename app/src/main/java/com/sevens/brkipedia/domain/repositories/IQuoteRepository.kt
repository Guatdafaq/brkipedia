package com.sevens.brkipedia.domain.repositories

import com.sevens.brkipedia.domain.models.DomainQuote

interface IQuoteRepository {

    suspend fun getAllQuotes(): List<DomainQuote>
    suspend fun getQuotesByAuthor(author: String): List<DomainQuote>

}
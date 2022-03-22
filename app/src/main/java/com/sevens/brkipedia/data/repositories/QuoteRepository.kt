package com.sevens.brkipedia.data.repositories

import com.sevens.brkipedia.data.local.dao.LocalQuoteDao
import com.sevens.brkipedia.data.mappers.toDataBase
import com.sevens.brkipedia.data.mappers.toDomain
import com.sevens.brkipedia.data.remote.services.QuoteService
import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: LocalQuoteDao
) : IQuoteRepository {

    override suspend fun getAllQuotesFromApi() = api.getQuotes().toDomain()

    override suspend fun getAllQuotesFromDatabase() = api.getQuotes().toDomain()

    override suspend fun insertQuotes(quotes: List<DomainQuote>) {
        quoteDao.insertQuotes(quotes.toDataBase())
    }

    override suspend fun getQuotesByAuthorFromApi(author: String): List<DomainQuote> {
        val authorQuery = author.replace("\\s".toRegex(), "+")
        val response = api.getQuotesByAuthor(authorQuery)
        return response.toDomain()
    }

    override suspend fun getQuotesByAuthorFromDatabase(author: String): List<DomainQuote> {
        val response = quoteDao.getQuotesByAuthor(author)
        return response.toDomain()
    }

    override suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }

}
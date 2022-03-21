package com.sevens.brkipedia.data.repositories

import com.sevens.brkipedia.data.local.dao.LocalCharacterDao
import com.sevens.brkipedia.data.local.dao.LocalQuoteDao
import com.sevens.brkipedia.data.mappers.toDataBase
import com.sevens.brkipedia.data.mappers.toDomain
import com.sevens.brkipedia.data.remote.services.QuoteService
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: LocalQuoteDao
) {
    suspend fun getAllQuotesFromApi() = api.getQuotes().toDomain()

    suspend fun getAllQuotesFromDatabase()  = api.getQuotes().toDomain()

    suspend fun insertQuotes(quotes: List<DomainQuote>) {
        quoteDao.insertQuotes(quotes.toDataBase())
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

    suspend fun getQuotesByAuthorFromApi(author: String): List<DomainQuote> {
        val authorQuery = author.replace("\\s".toRegex(), "+")
        val response = api.getQuotesByAuthor(authorQuery)
        return response.toDomain()
    }

    suspend fun getQuotesByAuthorFromDatabase(author: String): List<DomainQuote> {
        val authorQuery = author.replace("\\s".toRegex(), "+")
        val response = api.getQuotesByAuthor(authorQuery)
        return response.toDomain()
    }

}
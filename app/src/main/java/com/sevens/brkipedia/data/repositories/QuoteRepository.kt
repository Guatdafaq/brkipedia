package com.sevens.brkipedia.data.repositories

import com.sevens.brkipedia.data.mappers.toDomain
import com.sevens.brkipedia.data.remote.services.QuoteService
import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.domain.repositories.IQuoteRepository

class QuoteRepository : IQuoteRepository {

    private val api = QuoteService()

    override suspend fun getAllQuotes(): List<DomainQuote> {
        val response = api.getQuotes()
        //CharacterProvider.characters = response //TODO Implement provider
        return response.toDomain()
    }

    override suspend fun getQuotesByAuthor(author: String): List<DomainQuote> {
        val authorQuery = author.replace("\\s".toRegex(), "+")
        val response = api.getQuotesByAuthor(authorQuery)
        //CharacterProvider.characters = response //TODO Implement provider
        return response.toDomain()
    }

}
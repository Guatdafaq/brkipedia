package com.sevens.brkipedia.data.remote.services

import com.sevens.brkipedia.data.remote.RetrofitHelper
import com.sevens.brkipedia.data.remote.apis.QuoteApi
import com.sevens.brkipedia.data.remote.models.RemoteQuote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApi
    ) {

    suspend fun getQuotes(): List<RemoteQuote> {
        return withContext(Dispatchers.IO) {
            val response = api.getQuotes()
            response.body() ?: emptyList()
            //TODO Implement exceptions
        }
    }

    suspend fun getQuotesByAuthor(author: String): List<RemoteQuote> {
        return withContext(Dispatchers.IO) {
            val response = api.getQuotesByAuthor(author)
            response.body() ?: emptyList()
            //TODO Implement exceptions
        }
    }
}
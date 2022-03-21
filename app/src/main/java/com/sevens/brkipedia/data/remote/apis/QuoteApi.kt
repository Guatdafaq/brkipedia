package com.sevens.brkipedia.data.remote.apis

import com.sevens.brkipedia.data.remote.models.RemoteQuote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {
    @GET("quotes")
    suspend fun getQuotes() : Response<List<RemoteQuote>>

    @GET("quote")
    suspend fun getQuotesByAuthor(@Query("author", encoded = true) author: String?) : Response<List<RemoteQuote>>
}
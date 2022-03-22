package com.sevens.brkipedia.data.remote.services

import android.util.Log
import com.sevens.brkipedia.data.remote.apis.QuoteApi
import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import com.sevens.brkipedia.data.remote.models.RemoteQuote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApi
    ) {

    suspend fun getQuotes(): List<RemoteQuote> {
        return withContext(Dispatchers.IO) {
            var result: List<RemoteQuote> = emptyList()
            try{
                val response = api.getQuotes()
                response.body()?.let{
                    result = it
                }
            }catch(ex: Exception){
                Log.d("CHARACTER_API", ex.message!!)
                //TODO Implement exceptions
            }
            result
        }
    }

    suspend fun getQuotesByAuthor(author: String): List<RemoteQuote> {
        return withContext(Dispatchers.IO) {
            var result: List<RemoteQuote> = emptyList()
            try{
                val response = api.getQuotesByAuthor(author)
                response.body()?.let{
                    result = it
                }
            }catch(ex: Exception){
                Log.d("CHARACTER_API", ex.message!!)
                //TODO Implement exceptions
            }
            result
        }
    }
}
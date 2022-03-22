package com.sevens.brkipedia.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.stream.MalformedJsonException
import com.sevens.brkipedia.data.repositories.QuoteRepository
import com.sevens.brkipedia.domain.models.DomainQuote
import com.sevens.brkipedia.usecases.GetQuotes
import com.sevens.brkipedia.usecases.GetQuotesByAuthor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    val quotesUseCase : GetQuotes,
    val quotesByAuthorUseCase : GetQuotesByAuthor
) : ViewModel() {

    val quotes = MutableLiveData<List<DomainQuote>>()
    val quotesByAuthor = MutableLiveData<List<DomainQuote>>()

    fun getQuotes() {
        viewModelScope.launch{
            try{
                val result = quotesUseCase()
                quotesByAuthor.postValue(result)
            } catch (ex: MalformedJsonException){
                ex.message?.let { Log.i("API", it) }
            }
        }
    }
    fun getQuotesByAuthor(author: String) {
        viewModelScope.launch{
            try{
                val result = quotesByAuthorUseCase(author)
                quotesByAuthor.postValue(result)
            } catch (ex: MalformedJsonException){
                ex.message?.let { Log.i("API", it) }
            }
        }
    }
}
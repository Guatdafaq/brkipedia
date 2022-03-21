package com.sevens.brkipedia.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.stream.MalformedJsonException
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.usecases.GetCharacters
import com.sevens.brkipedia.usecases.GetCharactersByCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    val charactersUseCase : GetCharacters,
    val charactersByCategoryUseCase : GetCharactersByCategory
): ViewModel() {

    val category = MutableLiveData<Category>()
    private val _characters = MutableLiveData<List<DomainCharacter>>()
    val charactersByCategory = MutableLiveData<List<DomainCharacter>>()

    fun getCharacters() {
        viewModelScope.launch{
            try{
                val result = charactersUseCase()
                _characters.postValue(result)
            } catch (ex: MalformedJsonException){
                ex.message?.let { Log.i("API", it) }
            }
        }
    }

    fun getCharactersByCategory(category: Category) {
        viewModelScope.launch{
            try{
                val result = charactersByCategoryUseCase(category)
                charactersByCategory.postValue(result)
            } catch (ex: MalformedJsonException){
                ex.message?.let { Log.i("API", it) }
            }
        }
    }
}
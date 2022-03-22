package com.sevens.brkipedia.data.remote.services

import android.util.Log
import com.sevens.brkipedia.data.remote.apis.CharacterApi
import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val api: CharacterApi
){
    suspend fun getCharacters(): List<RemoteCharacter> {
        return withContext(Dispatchers.IO) {
            var result: List<RemoteCharacter> = emptyList()
            try{
                val response = api.getCharacters()
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

    suspend fun getCharactersByCategory(category: String): List<RemoteCharacter> {
        return withContext(Dispatchers.IO) {
            var result: List<RemoteCharacter> = emptyList()
            try{
                val response = api.getCharactersByCategory(category)
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
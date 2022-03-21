package com.sevens.brkipedia.data.remote.services

import com.sevens.brkipedia.data.remote.RetrofitHelper
import com.sevens.brkipedia.data.remote.apis.CharacterApi
import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val api: CharacterApi
){
    suspend fun getCharacters(): List<RemoteCharacter> {
        return withContext(Dispatchers.IO) {
                val response = api.getCharacters()
                response.body() ?: emptyList()
            //TODO Implement exceptions
        }
    }
}
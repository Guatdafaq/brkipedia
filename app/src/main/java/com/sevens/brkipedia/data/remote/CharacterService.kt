package com.sevens.brkipedia.data.remote

import com.sevens.brkipedia.core.RetrofitHelper
import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getCharacters(): List<RemoteCharacter> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CharacterApi::class.java).getCharacters()
            response.body() ?: emptyList()
            //TODO Implement exceptions
        }
    }
}
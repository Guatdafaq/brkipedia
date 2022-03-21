package com.sevens.brkipedia.data.remote.apis

import com.sevens.brkipedia.data.remote.models.RemoteCharacter
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters() : Response<List<RemoteCharacter>>

}
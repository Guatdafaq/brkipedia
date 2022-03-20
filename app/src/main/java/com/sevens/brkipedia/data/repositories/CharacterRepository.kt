package com.sevens.brkipedia.data.repositories

import com.sevens.brkipedia.data.mappers.toDomain
import com.sevens.brkipedia.data.remote.CharacterService
import com.sevens.brkipedia.domain.models.Character
import com.sevens.brkipedia.domain.repositories.ICharacterRepository

class CharacterRepository : ICharacterRepository {

    private val api = CharacterService()
    override suspend fun getAllCharacters(): List<Character>{
        val response = api.getCharacters()
        //CharacterProvider.characters = response //TODO Implement provider
        return response.toDomain()
    }

}
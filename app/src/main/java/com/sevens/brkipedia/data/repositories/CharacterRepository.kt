package com.sevens.brkipedia.data.repositories

import com.sevens.brkipedia.data.mappers.toDomain
import com.sevens.brkipedia.data.remote.services.CharacterService
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api : CharacterService
    ){

    suspend fun getAllCharacters(): List<DomainCharacter>{
        val response = api.getCharacters()
        //CharacterProvider.characters = response //TODO Implement provider
        return response.toDomain()
    }

    suspend fun getAllCharactersByCategory(category: Category): List<DomainCharacter> {
        val response = api.getCharacters().toDomain()
        val list: ArrayList<DomainCharacter> = ArrayList<DomainCharacter>()

        response.forEach { character ->
            character.category.forEach {
                if(it.value == category.value)
                    list.add(character)
            }
        }
        return list
    }

}
package com.sevens.brkipedia.domain.repositories

import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter

interface ICharacterRepository {
    suspend fun getAllCharactersFromApi(): List<DomainCharacter>
    suspend fun getAllCharactersFromDatabase(): List<DomainCharacter>
    suspend fun insertCharacters(characters: List<DomainCharacter>)
    suspend fun getAllCharactersByCategoryFromApi(category: Category): List<DomainCharacter>
    suspend fun getAllCharactersByCategoryFromDatabase(category: Category): List<DomainCharacter>
    suspend fun clearCharacters()
}
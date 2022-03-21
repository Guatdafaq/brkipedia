package com.sevens.brkipedia.domain.repositories

import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter

interface ICharacterRepository {

    suspend fun getAllCharacters(): List<DomainCharacter>
    suspend fun getAllCharactersByCategory(category: Category): List<DomainCharacter>

}
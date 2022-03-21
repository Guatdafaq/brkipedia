package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository

class GetCharactersByCategory (private val characterRepository: ICharacterRepository
) {
    suspend operator fun invoke(category: Category): List<DomainCharacter> = characterRepository.getAllCharactersByCategory(category)
}
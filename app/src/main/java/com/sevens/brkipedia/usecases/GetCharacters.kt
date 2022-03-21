package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository

class GetCharacters(
    private val characterRepository: ICharacterRepository
) {
    suspend operator fun invoke(): List<DomainCharacter> = characterRepository.getAllCharacters()
}
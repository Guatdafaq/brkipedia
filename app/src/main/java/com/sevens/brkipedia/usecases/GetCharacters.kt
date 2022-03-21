package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.data.repositories.CharacterRepository
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(): List<DomainCharacter> = characterRepository.getAllCharacters()
}
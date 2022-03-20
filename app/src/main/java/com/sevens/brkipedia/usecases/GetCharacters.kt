package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.models.Character
import com.sevens.brkipedia.domain.repositories.ICharacterRepository

class GetCharacters(
    private val characterRepository: ICharacterRepository
) {
    suspend operator fun invoke(): List<Character> = characterRepository.getAllCharacters()
}
package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val characterRepository: ICharacterRepository
) {
    suspend operator fun invoke(): List<DomainCharacter> {
        val characters = characterRepository.getAllCharactersFromApi()

        return if (characters.isNotEmpty()) {
            characterRepository.clearCharacters()
            characterRepository.insertCharacters(characters)
            characters
        }else{
            characterRepository.getAllCharactersFromDatabase()
        }
    }
}
package com.sevens.brkipedia.usecases

import com.sevens.brkipedia.data.repositories.CharacterRepository
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository
import javax.inject.Inject

class GetCharactersByCategory @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(category: Category): List<DomainCharacter> {

        val characters = characterRepository.getAllCharactersByCategoryFromApi(category)
        if(characters.isNotEmpty()) {
            characterRepository.clearCharacters()
            characterRepository.insertCharacters(characters)
        }else{
            characterRepository.getAllCharactersByCategoryFromDatabase(category)
        }
        return characters
    }
}
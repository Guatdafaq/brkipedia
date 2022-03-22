package com.sevens.brkipedia.data.repositories

import com.sevens.brkipedia.data.local.dao.LocalCharacterDao
import com.sevens.brkipedia.data.mappers.toDataBase
import com.sevens.brkipedia.data.mappers.toDomain
import com.sevens.brkipedia.data.remote.services.CharacterService
import com.sevens.brkipedia.domain.common.Category
import com.sevens.brkipedia.domain.models.DomainCharacter
import com.sevens.brkipedia.domain.repositories.ICharacterRepository
import java.util.*
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterService,
    private val characterDao: LocalCharacterDao
) :ICharacterRepository {

    override suspend fun getAllCharactersFromApi() = api.getCharacters().toDomain()

    override suspend fun getAllCharactersFromDatabase() = characterDao.getAllCharacters().toDomain()

    override suspend fun insertCharacters(characters: List<DomainCharacter>) {
        characterDao.insertCharacters(characters.toDataBase())
    }

    override suspend fun getAllCharactersByCategoryFromApi(category: Category) =
        api.getCharactersByCategory(
            category.value.lowercase()
                .replace("_".toRegex(), " ")
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                .replace("\\s".toRegex(), "+")
        ).toDomain()

    override suspend fun getAllCharactersByCategoryFromDatabase(category: Category) =
        characterDao.getCharactersByCategory(
            category.value
        ).toDomain()

    override suspend fun clearCharacters() {
        characterDao.deleteAllCharacters()
    }

}
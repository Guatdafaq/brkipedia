package com.sevens.brkipedia.domain.repositories

import com.sevens.brkipedia.domain.models.Character

interface ICharacterRepository {

    suspend fun getAllCharacters(): List<Character>

}
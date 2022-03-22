package com.sevens.brkipedia.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sevens.brkipedia.data.local.models.LocalCharacter

@Dao
interface LocalCharacterDao {

    @Query(
        """
        SELECT * FROM character_table
        """
    )
    suspend fun getAllCharacters(): List<LocalCharacter>

    @Query(
        """
        SELECT * FROM character_table 
        WHERE category LIKE '%' || :category || '%'
        """
    )
    suspend fun getCharactersByCategory(category: String): List<LocalCharacter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(character: List<LocalCharacter>)

    @Query(
        """
        DELETE FROM character_table
    """
    )
    suspend fun deleteAllCharacters()

}
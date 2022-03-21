package com.sevens.brkipedia.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sevens.brkipedia.data.local.models.LocalQuote

@Dao
interface LocalQuoteDao {

    @Query(
        """
        SELECT * FROM quote_table
        """
    )
    suspend fun getAllQuotes(): List<LocalQuote>

    @Query(
        """
        SELECT * FROM quote_table 
        WHERE author = :author
        """
    )
    suspend fun getQuotesByAuthor(author: String): List<LocalQuote>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotes(quotes: List<LocalQuote>)

    @Query(
        """
        DELETE FROM quote_table
    """
    )
    suspend fun deleteAllQuotes()

}
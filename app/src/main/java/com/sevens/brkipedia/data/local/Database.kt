package com.sevens.brkipedia.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sevens.brkipedia.data.local.dao.LocalCharacterDao
import com.sevens.brkipedia.data.local.dao.LocalQuoteDao
import com.sevens.brkipedia.data.local.models.LocalCharacter
import com.sevens.brkipedia.data.local.models.LocalQuote
import com.sevens.brkipedia.domain.common.Constants

@Database(entities = [
    LocalCharacter::class,
    LocalQuote::class
], version = Constants.DB_VERSION)
@TypeConverters(Converters::class)
abstract class BPDatabase : RoomDatabase() {

    abstract fun getLocalCharacterDao(): LocalCharacterDao

    abstract fun getLocalQuoteDao(): LocalQuoteDao

}
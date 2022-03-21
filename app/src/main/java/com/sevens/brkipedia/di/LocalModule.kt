package com.sevens.brkipedia.di

import android.content.Context
import androidx.room.Room
import com.sevens.brkipedia.data.local.BPDatabase
import com.sevens.brkipedia.data.local.dao.LocalCharacterDao
import com.sevens.brkipedia.domain.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BPDatabase::class.java, Constants.DB_NAME).build()

    @Singleton
    @Provides
    fun provideCharacterDao(db: BPDatabase) = db.getLocalCharacterDao()

    @Singleton
    @Provides
    fun provideQuoteDao(db: BPDatabase) = db.getLocalQuoteDao()
}
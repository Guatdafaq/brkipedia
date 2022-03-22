package com.sevens.brkipedia.di

import com.sevens.brkipedia.data.local.dao.LocalCharacterDao
import com.sevens.brkipedia.data.remote.services.CharacterService
import com.sevens.brkipedia.data.repositories.CharacterRepository
import com.sevens.brkipedia.domain.repositories.ICharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object CharactersModule {
    @Provides
    fun provideCharacterRepository(
        characterApi: CharacterService,
        characterDao: LocalCharacterDao
    ) : ICharacterRepository{
        return CharacterRepository(
        characterApi,
        characterDao
        )
    }
}
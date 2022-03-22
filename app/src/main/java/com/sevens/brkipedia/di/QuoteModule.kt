package com.sevens.brkipedia.di

import com.sevens.brkipedia.data.local.dao.LocalQuoteDao
import com.sevens.brkipedia.data.remote.services.QuoteService
import com.sevens.brkipedia.data.repositories.QuoteRepository
import com.sevens.brkipedia.domain.repositories.IQuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object QuoteModule {
    @Provides
    fun provideQuoteRepository(
        quoteApi: QuoteService,
        quoteDao: LocalQuoteDao
    ): IQuoteRepository {
        return QuoteRepository(
            quoteApi,
            quoteDao
        )
    }
}

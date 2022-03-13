package com.hasib.currencyrates.di

import com.hasib.currencyrates.data.repo.CountryRepository
import com.hasib.currencyrates.data.repo.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCountryRepository(repositoryImpl: CountryRepositoryImpl): CountryRepository
}
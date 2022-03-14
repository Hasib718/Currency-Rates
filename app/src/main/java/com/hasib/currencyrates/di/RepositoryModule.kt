package com.hasib.currencyrates.di

import com.hasib.currencyrates.data.repo.country.CountryRepository
import com.hasib.currencyrates.data.repo.country.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCountryRepository(repositoryImpl: CountryRepositoryImpl): CountryRepository
}
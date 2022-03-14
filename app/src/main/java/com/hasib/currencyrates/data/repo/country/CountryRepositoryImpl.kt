package com.hasib.currencyrates.data.repo.country

import com.hasib.currencyrates.data.source.local.db.AppDatabase
import com.hasib.currencyrates.data.source.remote.CountryService
import com.hasib.currencyrates.model.toCountryEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class CountryRepositoryImpl @Inject constructor(
    private val api: CountryService,
    private val db: AppDatabase
) : CountryRepository {
    private val countryDao = db.countryDao()

    override suspend fun loadAllCountries(url: String): Unit = withContext(Dispatchers.IO) {
        if (countryDao.getCountries().first().isEmpty()) {
            api.allCountries(url).body()?.map { it.toCountryEntity() }
                ?.let { countryDao.insertCountries(it) }
        }
    }
}
package com.hasib.currencyrates.data.repo

import androidx.room.withTransaction
import com.hasib.currencyrates.data.source.local.db.AppDatabase
import com.hasib.currencyrates.data.source.remote.country.CountryService
import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.helper.util.networkBoundResource
import com.hasib.currencyrates.model.CountryItem
import com.hasib.currencyrates.model.toCountryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: CountryService,
    private val db: AppDatabase
) : CountryRepository {
    private val countryDao = db.countryDao()

    override fun loadAllCountries(): Flow<Resource<List<CountryItem>>> =
        networkBoundResource(
            query = {
                countryDao.getCountries()
            },
            fetch = {
                api.allCountries()
            },
            saveFetchResult = { list ->
                db.withTransaction {
                    countryDao.deleteAllCountries()
                    countryDao.insertCountries(list.map { it.toCountryEntity() })
                }
            },
            shouldFetch = {
                it.isEmpty()
            }
        )
}
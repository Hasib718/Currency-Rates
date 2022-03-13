package com.hasib.currencyrates.data.repo

import com.hasib.currencyrates.data.source.remote.country.CountryRemoteDataSource
import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CountryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val remoteDataSource: CountryRemoteDataSource
) : CountryRepository {

    override suspend fun loadAllCountries(): Resource<List<CountryResponse>> =
        withContext(Dispatchers.IO) {
            return@withContext remoteDataSource.getCountries()
        }
}
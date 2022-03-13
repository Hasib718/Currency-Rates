package com.hasib.currencyrates.data.source.remote.country

import com.hasib.currencyrates.data.source.remote.BaseDataSource
import javax.inject.Inject

class CountryRemoteDataSource @Inject constructor(
    private val countryService: CountryService
): BaseDataSource() {

    suspend fun getCountries() = getResult { countryService.allCountries() }
}
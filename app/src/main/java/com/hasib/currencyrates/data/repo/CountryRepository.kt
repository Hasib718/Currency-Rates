package com.hasib.currencyrates.data.repo

import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CountryResponse

interface CountryRepository {

    suspend fun loadAllCountries(): Resource<List<CountryResponse>>
}
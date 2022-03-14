package com.hasib.currencyrates.data.repo.country

import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CountryItem
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun loadAllCountries(): Flow<Resource<List<CountryItem>>>
}
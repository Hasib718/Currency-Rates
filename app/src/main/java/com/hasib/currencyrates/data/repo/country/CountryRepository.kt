package com.hasib.currencyrates.data.repo.country

interface CountryRepository {

    suspend fun loadAllCountries(url: String)
}
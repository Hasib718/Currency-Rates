package com.hasib.currencyrates.data.source.remote

import com.hasib.currencyrates.model.CountryResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {

    @GET("all")
    suspend fun allCountries(): List<CountryResponse>

    @GET("name/{name}")
    suspend fun countryInfo(@Path("name") name: String): List<CountryResponse>
}
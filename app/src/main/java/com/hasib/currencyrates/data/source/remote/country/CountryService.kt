package com.hasib.currencyrates.data.source.remote.country

import com.hasib.currencyrates.model.CountryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {

    @GET("all")
    suspend fun allCountries(): Response<List<CountryResponse>>
}
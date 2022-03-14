package com.hasib.currencyrates.data.source.remote

import com.hasib.currencyrates.model.CountryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CountryService {

    @GET
    suspend fun allCountries(@Url url: String): Response<List<CountryResponse>>
}
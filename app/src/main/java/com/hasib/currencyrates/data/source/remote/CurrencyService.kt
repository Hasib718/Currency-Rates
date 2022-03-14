package com.hasib.currencyrates.data.source.remote

import com.hasib.currencyrates.model.CurrencyRateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET("latest.json")
    suspend fun getLatestCurrencyRates(
        @Query("app_id") appId: String
    ): Response<CurrencyRateResponse>
}
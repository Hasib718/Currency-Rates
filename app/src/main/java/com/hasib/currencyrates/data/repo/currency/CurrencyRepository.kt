package com.hasib.currencyrates.data.repo.currency

import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CurrencyInfoEntity
import com.hasib.currencyrates.model.CurrencyRateEntity
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    fun loadLatestCurrencyRates(
        appId: String,
        base: String
    ): Flow<Resource<List<CurrencyRateEntity>>>

    fun loadCurrenciesInfo(): Flow<Resource<List<CurrencyInfoEntity>>>
}
package com.hasib.currencyrates.data.repo.currency

import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.model.CountryItem
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    fun loadLatestCurrencyRates(
        appId: String
    ): Flow<Resource<List<CountryItem>>>
}
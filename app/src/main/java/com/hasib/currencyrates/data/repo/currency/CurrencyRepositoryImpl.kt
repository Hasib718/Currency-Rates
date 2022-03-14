package com.hasib.currencyrates.data.repo.currency

import androidx.room.withTransaction
import com.hasib.currencyrates.data.AppConstant
import com.hasib.currencyrates.data.source.local.db.AppDatabase
import com.hasib.currencyrates.data.source.local.preference.AppPreference
import com.hasib.currencyrates.data.source.remote.CurrencyService
import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.helper.util.networkBoundResource
import com.hasib.currencyrates.model.CountryItem
import com.hasib.currencyrates.model.CurrencyRateEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import kotlin.math.abs

@ViewModelScoped
class CurrencyRepositoryImpl @Inject constructor(
    private val api: CurrencyService,
    private val db: AppDatabase,
    private val preference: AppPreference
) : CurrencyRepository {
    private val currencyRateDao = db.currencyRateDao()

    override fun loadLatestCurrencyRates(
        appId: String
    ): Flow<Resource<List<CountryItem>>> =
        networkBoundResource(
            query = {
                currencyRateDao.getCountriesLatestCurrencyRate()
            },
            fetch = {
                val response = api.getLatestCurrencyRates(appId)
                if (response.isSuccessful) {
                    preference.storeCurrencyRatesFetchingTime(System.currentTimeMillis())
                }
                response.body()
            },
            saveFetchResult = { response ->
                db.withTransaction {
                    currencyRateDao.deleteAllCurrencyRates()
                    currencyRateDao.insertCurrencyRates(response!!.rates.map {
                        CurrencyRateEntity(
                            it.key,
                            it.value
                        )
                    })
                }
            },
            shouldFetch = {
                val long = preference.currencyRatesFetchingTimeFlow.first()

                return@networkBoundResource abs(long - System.currentTimeMillis()) >= AppConstant.CURRENCY_RATES_FETCHING_TIME_PERIOD
            }
        )

}
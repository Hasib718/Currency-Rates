package com.hasib.currencyrates.data.repo.currency

import androidx.room.withTransaction
import com.hasib.currencyrates.data.source.local.db.AppDatabase
import com.hasib.currencyrates.data.source.remote.CurrencyService
import com.hasib.currencyrates.helper.util.Resource
import com.hasib.currencyrates.helper.util.networkBoundResource
import com.hasib.currencyrates.model.CurrencyInfoEntity
import com.hasib.currencyrates.model.CurrencyRateEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val api: CurrencyService,
    private val db: AppDatabase
) : CurrencyRepository {
    private val currencyInfoDao = db.currencyInfoDao()
    private val currencyRateDao = db.currencyRateDao()

    override fun loadLatestCurrencyRates(
        appId: String,
        base: String
    ): Flow<Resource<List<CurrencyRateEntity>>> =
        networkBoundResource(
            query = {
                currencyRateDao.getLatestCurrencyRates()
            },
            fetch = {
                api.getLatestCurrencyRates(appId, base)
            },
            saveFetchResult = { rates ->
                db.withTransaction {
                    currencyRateDao.deleteAllCurrencyRates()
                    currencyRateDao.insertCurrencyRates(rates.rates.map {
                        CurrencyRateEntity(
                            it.key,
                            it.value
                        )
                    })
                }
            }
        )

    override fun loadCurrenciesInfo(): Flow<Resource<List<CurrencyInfoEntity>>> =
        networkBoundResource(
            query = {
                currencyInfoDao.getCurrenciesInfo()
            },
            fetch = {
                api.getCurrenciesInfo()
            },
            saveFetchResult = { currenciesInfo ->
                db.withTransaction {
                    currencyInfoDao.deleteAllCurrencies()
                    currencyInfoDao.insertCurrencies(currenciesInfo.map {
                        CurrencyInfoEntity(
                            it.key,
                            it.value
                        )
                    })
                }

            },
            shouldFetch = {
                it.isEmpty()
            }
        )
}
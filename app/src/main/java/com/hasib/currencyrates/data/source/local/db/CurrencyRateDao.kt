package com.hasib.currencyrates.data.source.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasib.currencyrates.model.CurrencyRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyRateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencyRates(currencyRates: List<CurrencyRateEntity>)

    @Query("DELETE FROM ${DBConstant.TABLE_CURRENCY_RATE}")
    suspend fun deleteAllCurrencyRates()

    @Query("SELECT * FROM ${DBConstant.TABLE_CURRENCY_RATE}")
    fun getLatestCurrencyRates(): Flow<List<CurrencyRateEntity>>
}
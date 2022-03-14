package com.hasib.currencyrates.data.source.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasib.currencyrates.model.CurrencyInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(currencyEntities: List<CurrencyInfoEntity>)

    @Query("DELETE FROM ${DBConstant.TABLE_CURRENCY_INFO}")
    suspend fun deleteAllCurrencies()

    @Query("SELECT * FROM ${DBConstant.TABLE_CURRENCY_INFO}")
    fun getCurrenciesInfo(): Flow<List<CurrencyInfoEntity>>
}
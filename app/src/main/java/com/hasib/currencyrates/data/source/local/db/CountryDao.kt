package com.hasib.currencyrates.data.source.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasib.currencyrates.model.CountryEntity
import com.hasib.currencyrates.model.CountryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Query("DELETE FROM ${DBConstant.TABLE_COUNTRY}")
    suspend fun deleteAllCountries()

    @Query(
        "SELECT ${DBConstant.COLUMN_COUNTRY_COMMON_NAME}, " +
                "${DBConstant.COLUMN_COUNTRY_CURRENCY_CODE}, " +
                "${DBConstant.COLUMN_COUNTRY_CURRENCY_NAME}, " +
                "${DBConstant.COLUMN_COUNTRY_FLAG_URL} " +
                "FROM ${DBConstant.TABLE_COUNTRY} " +
                "ORDER BY ${DBConstant.COLUMN_COUNTRY_COMMON_NAME}"
    )
    fun getCountries(): Flow<List<CountryItem>>
}
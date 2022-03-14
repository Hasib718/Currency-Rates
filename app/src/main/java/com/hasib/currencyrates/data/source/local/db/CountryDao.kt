package com.hasib.currencyrates.data.source.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasib.currencyrates.model.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Query("DELETE FROM ${DBConstant.TABLE_COUNTRY}")
    suspend fun deleteAllCountries()

    @Query("SELECT * FROM ${DBConstant.TABLE_COUNTRY}")
    fun getCountries(): Flow<List<CountryEntity>>
}
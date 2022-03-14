package com.hasib.currencyrates.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasib.currencyrates.model.CountryEntity
import com.hasib.currencyrates.model.CurrencyRateEntity

@Database(
    entities = [CountryEntity::class, CurrencyRateEntity::class],
    version = DBConstant.DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao
    abstract fun currencyRateDao(): CurrencyRateDao
}
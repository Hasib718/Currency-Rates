package com.hasib.currencyrates.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasib.currencyrates.model.CountryEntity

@Database(
    entities = [CountryEntity::class],
    version = DBConstant.DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao
}
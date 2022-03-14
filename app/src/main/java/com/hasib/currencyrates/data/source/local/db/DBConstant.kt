package com.hasib.currencyrates.data.source.local.db

object DBConstant {
    const val DB_VERSION = 1
    const val DATABASE_NAME = "CurrencyRatesAppDatabase"

    const val TABLE_COUNTRY = "Country"
    const val COLUMN_COUNTRY_COMMON_NAME = "commonName"
    const val COLUMN_COUNTRY_CURRENCY_NAME = "currencyName"
    const val COLUMN_CURRENCY_RATE_RATE = "rate"
    const val COLUMN_COUNTRY_FLAG_URL = "flagUrl"

    const val TABLE_CURRENCY_RATE = "CurrencyRate"
}
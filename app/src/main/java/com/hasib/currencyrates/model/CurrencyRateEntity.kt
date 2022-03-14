package com.hasib.currencyrates.model

import androidx.room.Entity
import com.hasib.currencyrates.data.source.local.db.DBConstant

@Entity(tableName = DBConstant.TABLE_CURRENCY_RATE)
data class CurrencyRateEntity(
    val code: String,
    val rate: Double
)
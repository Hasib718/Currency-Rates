package com.hasib.currencyrates.model

import androidx.room.Entity
import com.hasib.currencyrates.data.source.local.db.DBConstant

@Entity(tableName = DBConstant.TABLE_CURRENCY_INFO)
data class CurrencyInfoEntity(
    val code: String,
    val fullName: String
)

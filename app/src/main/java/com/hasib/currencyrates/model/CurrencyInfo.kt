package com.hasib.currencyrates.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hasib.currencyrates.data.source.local.db.DBConstant

@Entity(tableName = DBConstant.TABLE_CURRENCY_INFO)
data class CurrencyInfo(
    @PrimaryKey val code: String,
    val fullName: String
)

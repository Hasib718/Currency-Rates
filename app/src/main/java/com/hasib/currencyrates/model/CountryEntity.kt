package com.hasib.currencyrates.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hasib.currencyrates.data.source.local.db.DBConstant

@Entity(tableName = DBConstant.TABLE_COUNTRY)
data class CountryEntity(
    @PrimaryKey val commonName: String,
    val officialName: String?,
    val independent: Boolean?,
    val unMember: Boolean?,
    val currencyCode: String?,
    val currencyName: String?,
    val currencySymbol: String?,
    val capital: String?,
    val region: String?,
    val subregion: String?,
    val languages: String?,
    val area: Double?,
    val population: Long?,
    val timezone: String?,
    val continents: String?,
    val flagUrl: String?
)
package com.hasib.currencyrates.model

data class CountryItem(
    val commonName: String,
    val currencyName: String,
    val rate: Double,
    val flagUrl: String
)
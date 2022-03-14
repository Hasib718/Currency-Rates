package com.hasib.currencyrates.model

data class CountryItem(
    val commonName: String,
    val fullName: String,
    val rate: Double,
    val flagUrl: String
)
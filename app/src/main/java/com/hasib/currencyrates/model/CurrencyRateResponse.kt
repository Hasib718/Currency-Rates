package com.hasib.currencyrates.model

data class CurrencyRateResponse(
    val disclaimer: String,
    val license: String,
    val timestamp: Long,
    val base: String,
    val rates: Map<String, Double>
)
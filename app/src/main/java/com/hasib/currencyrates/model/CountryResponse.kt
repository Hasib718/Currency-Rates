package com.hasib.currencyrates.model

data class CountryResponse(
    val name: Name,
    val independent: Boolean,
    val unMember: Boolean,
    val currencies: Map<String, CurrencyDetail>,
    val capital: List<String>,
    val region: String,
    val subregion: String,
    val languages: Map<String, String>,
    val area: Double,
    val population: Long,
    val timezones: List<String>,
    val continents: List<String>,
    val flags: Flags
)

fun CountryResponse.toCountryEntity(): CountryEntity {
    var cCode: String
    var cName = ""
    var cSymbol = ""

    currencies.let {
        cCode =
            if (currencies.keys.size > 1) currencies.keys.joinToString(separator = "#") else currencies.keys.first()
        cName =
            if (currencies.keys.size > 1) currencies.values.joinToString(separator = "#") { it.name } else currencies.values.first().name
        cSymbol =
            if (currencies.keys.size > 1) currencies.values.joinToString(separator = "#") { it.symbol } else currencies.values.first().symbol
    }

    return CountryEntity(
        commonName = name.common,
        officialName = name.official,
        independent = independent,
        unMember = unMember,
        currencyCode = cCode,
        currencyName = cName,
        currencySymbol = cSymbol,
        capital = if (capital.isNullOrEmpty()) "" else capital[0],
        region = region,
        subregion = if (subregion.isNullOrEmpty()) "" else subregion,
        languages = if (languages.isNullOrEmpty()) "" else languages.map { "${it.key}%${it.value}" }
            .joinToString(separator = "#"),
        area = area,
        population = population,
        timezone = if (timezones.size > 1) timezones.joinToString("#") else timezones[0],
        continents = continents[0],
        flagUrl = flags.png
    )
}
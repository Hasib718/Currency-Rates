package com.hasib.currencyrates.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryResponse(
    @SerializedName("name") var name: Name? = Name(),
    @SerializedName("independent") var independent: Boolean? = null,
    @SerializedName("unMember") var unMember: Boolean? = null,
    @SerializedName("currencies") var currencies: HashMap<String, CurrencyDetail> = HashMap(),
    @SerializedName("capital") var capital: ArrayList<String> = arrayListOf(),
    @SerializedName("region") var region: String? = null,
    @SerializedName("subregion") var subregion: String? = null,
    @SerializedName("languages") var languages: HashMap<String, String> = HashMap(),
    @SerializedName("area") var area: Long? = null,
    @SerializedName("population") var population: Long? = null,
    @SerializedName("timezones") var timezones: ArrayList<String> = arrayListOf(),
    @SerializedName("continents") var continents: ArrayList<String> = arrayListOf(),
    @SerializedName("flags") var flags: Flags? = Flags()
): Parcelable
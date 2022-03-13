package com.hasib.currencyrates.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    @SerializedName("common") var common: String? = null,
    @SerializedName("official") var official: String? = null
): Parcelable
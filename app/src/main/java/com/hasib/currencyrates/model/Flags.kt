package com.hasib.currencyrates.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flags (
  @SerializedName("png" ) var png : String? = null
): Parcelable
package ru.msokolov.cryptomonitorapp.data.network.currency.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyInfoDto(

    @SerializedName("rate")
    @Expose
    var rate: Double? = null,
    @SerializedName("timestamp")
    @Expose
    var timestamp: Int? = null

)
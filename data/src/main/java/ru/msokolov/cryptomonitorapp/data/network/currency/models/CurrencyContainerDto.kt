package ru.msokolov.cryptomonitorapp.data.network.currency.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyContainerDto(

    @SerializedName("date")
    @Expose
    var date: String? = null,
    @SerializedName("info")
    @Expose
    var info: CurrencyInfoDto? = CurrencyInfoDto(),
    @SerializedName("query")
    @Expose
    var query: CurrencyExchangeRateDto? = CurrencyExchangeRateDto(),
    @SerializedName("result")
    @Expose
    var result: Double? = null,
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

)
package ru.msokolov.cryptomonitorapp.data.network.currency.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrencyExchangeRateDto(

    @SerializedName("amount")
    @Expose
    var amount: Int? = null,
    @SerializedName("from")
    @Expose
    var from: String? = null,
    @SerializedName("to")
    @Expose
    var to: String? = null

)
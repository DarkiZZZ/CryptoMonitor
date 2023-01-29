package ru.msokolov.cryptomonitorapp.data.network.crypto.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNamesListDto (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDto>? = null
)

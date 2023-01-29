package ru.msokolov.cryptomonitorapp.data.network.currency

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.msokolov.cryptomonitorapp.data.network.currency.models.CurrencyContainerDto

interface CurrencyApiService {

    @GET("convert")
    @Headers("apikey:gLDUM9F4088lIuY2F9QQEZD22Q6iO37R")
    suspend fun getTopCoinsInfo(
        @Query(QUERY_PARAM_TO) to: String = RUB,
        @Query(QUERY_PARAM_FROM) from: String = USD,
        @Query(QUERY_PARAM_AMOUNT) amount: Int = 1
    ): CurrencyContainerDto


    companion object {
        private const val USD = "USD"
        private const val RUB = "RUB"
        private const val QUERY_PARAM_TO = "to"
        private const val QUERY_PARAM_FROM = "from"
        private const val QUERY_PARAM_AMOUNT = "USD"
    }
}
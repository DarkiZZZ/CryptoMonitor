package ru.msokolov.cryptomonitorapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.msokolov.cryptomonitorapp.data.network.crypto.CryptoApiService
import ru.msokolov.cryptomonitorapp.data.network.currency.CurrencyApiService

object ApiFactory {

    private const val CRYPTO_BASE_URL = "https://min-api.cryptocompare.com/data/"
    private const val CURRENCY_BASE_URL = "https://api.apilayer.com/fixer/"

    private val cryptoRetrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(CRYPTO_BASE_URL)
        .build()

    val cryptoApiService = cryptoRetrofit.create(CryptoApiService::class.java)

    private val currencyRetrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(CURRENCY_BASE_URL)
        .build()

    val currencyApiService = currencyRetrofit.create(CurrencyApiService::class.java)

}

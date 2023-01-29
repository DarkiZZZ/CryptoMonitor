package ru.msokolov.cryptomonitorapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.msokolov.cryptomonitorapp.data.network.crypto.CryptoApiService

object ApiFactory {

    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"

    private val cryptoRetrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val cryptoApiService = cryptoRetrofit.create(CryptoApiService::class.java)
}

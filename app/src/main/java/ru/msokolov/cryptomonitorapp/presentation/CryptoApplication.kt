package ru.msokolov.cryptomonitorapp.presentation

import android.app.Application
import androidx.work.Configuration
import ru.msokolov.cryptomonitorapp.data.database.AppDatabase
import ru.msokolov.cryptomonitorapp.data.mappers.CoinMapper
import ru.msokolov.cryptomonitorapp.data.network.ApiFactory
import ru.msokolov.cryptomonitorapp.data.workers.RefreshWorkerFactory
import ru.msokolov.cryptomonitorapp.di.DaggerApplicationComponent

class CryptoApplication : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(
                RefreshWorkerFactory(
                    AppDatabase.getInstance(this).coinPriceInfoDao(),
                    ApiFactory.apiService,
                    CoinMapper()
                )
            ).build()
    }
}
package ru.msokolov.cryptomonitorapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.msokolov.cryptomonitorapp.data.database.AppDatabase
import ru.msokolov.cryptomonitorapp.data.database.dao.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.network.ApiFactory
import ru.msokolov.cryptomonitorapp.data.network.crypto.CryptoApiService

@Module
interface DataModule {

    companion object{

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): CryptoApiService {
            return ApiFactory.cryptoApiService
        }
    }
}
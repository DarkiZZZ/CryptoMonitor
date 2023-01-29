package ru.msokolov.cryptomonitorapp.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.msokolov.cryptomonitorapp.data.database.AppDatabase
import ru.msokolov.cryptomonitorapp.data.database.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.network.ApiFactory
import ru.msokolov.cryptomonitorapp.data.network.ApiService
import ru.msokolov.cryptomonitorapp.data.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain.CoinRepository

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object{

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao{
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService{
            return ApiFactory.apiService
        }
    }
}
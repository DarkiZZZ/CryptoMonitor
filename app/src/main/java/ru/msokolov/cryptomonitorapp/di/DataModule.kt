package ru.msokolov.cryptomonitorapp.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.msokolov.cryptomonitorapp.data.database.AppDatabase
import ru.msokolov.cryptomonitorapp.data.database.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain.CoinRepository

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object{

        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao{
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }
}
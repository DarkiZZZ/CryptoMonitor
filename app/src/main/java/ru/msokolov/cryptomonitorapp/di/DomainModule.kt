package ru.msokolov.cryptomonitorapp.di

import dagger.Binds
import dagger.Module
import ru.msokolov.cryptomonitorapp.data.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain2.CoinRepository

@Module
interface DomainModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

}
package ru.msokolov.cryptomonitorapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.msokolov.cryptomonitorapp.data.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain2.CoinRepository
import ru.msokolov.cryptomonitorapp.domain2.usecase.GetCoinInfoListUseCase
import ru.msokolov.cryptomonitorapp.domain2.usecase.GetCoinInfoUseCase
import ru.msokolov.cryptomonitorapp.domain2.usecase.LoadDataUseCase

@Module
interface DomainModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository


   /* @Provides
    fun provideGetCoinInfoListUseCase(repository: CoinRepository): GetCoinInfoListUseCase{
        return GetCoinInfoListUseCase(repository = repository)
    }

    @Provides
    fun provideGetCoinInfoUseCase(repository: CoinRepository): GetCoinInfoUseCase{
        return GetCoinInfoUseCase(repository = repository)
    }

    @Provides
    fun provideLoadDataUseCase(repository: CoinRepository): LoadDataUseCase{
        return LoadDataUseCase(repository = repository)
    }*/
}
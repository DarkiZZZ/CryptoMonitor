package ru.msokolov.cryptomonitorapp.di

import dagger.Binds
import dagger.Module
import ru.msokolov.cryptomonitorapp.data.network.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.data.firebase.repository.FirebaseRepositoryImpl
import ru.msokolov.cryptomonitorapp.data.firebase.repository.SignUpFirebaseRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain.repository.database.CoinRepository
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignUpFirebaseRepository

@Module
interface DomainModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    @Binds
    @ApplicationScope
    fun bindFirebaseRepository(impl: FirebaseRepositoryImpl): FirebaseRepository

    @Binds
    @ApplicationScope
    fun bindSignUpFirebaseRepository(impl: SignUpFirebaseRepositoryImpl): SignUpFirebaseRepository

}
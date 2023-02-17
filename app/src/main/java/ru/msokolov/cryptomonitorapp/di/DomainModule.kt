package ru.msokolov.cryptomonitorapp.di

import dagger.Binds
import dagger.Module
import ru.msokolov.cryptomonitorapp.data.firebase.repository.AuthorizationFirebaseRepositoryImpl
import ru.msokolov.cryptomonitorapp.data.firebase.repository.SignInFirebaseRepositoryImpl
import ru.msokolov.cryptomonitorapp.data.firebase.repository.SignUpFirebaseRepositoryImpl
import ru.msokolov.cryptomonitorapp.data.network.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain.repository.database.CoinRepository
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.AuthorizationFirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignInFirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignUpFirebaseRepository
import javax.inject.Singleton

@Module
interface DomainModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    @Binds
    @ApplicationScope
    fun bindSignUpFirebaseRepository(impl: SignUpFirebaseRepositoryImpl): SignUpFirebaseRepository

    @Binds
    @ApplicationScope
    fun bindSignInFirebaseRepository(impl: SignInFirebaseRepositoryImpl): SignInFirebaseRepository

    @Binds
    @ApplicationScope
    fun bindAuthorizationFirebaseRepository(impl: AuthorizationFirebaseRepositoryImpl): AuthorizationFirebaseRepository

}
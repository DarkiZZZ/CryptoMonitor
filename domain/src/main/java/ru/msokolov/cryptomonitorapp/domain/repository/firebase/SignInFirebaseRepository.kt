package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity

interface SignInFirebaseRepository: FirebaseRepository {

    fun signIn(userEntity: SignInUserEntity)
}
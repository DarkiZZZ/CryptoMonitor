package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity

interface SignUpFirebaseRepository: FirebaseRepository {

    fun signUp(userEntity: SignUpUserEntity)
}
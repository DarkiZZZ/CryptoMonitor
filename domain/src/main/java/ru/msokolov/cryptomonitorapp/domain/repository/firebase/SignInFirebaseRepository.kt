package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity

interface SignInFirebaseRepository {

    fun signIn(userEntity: SignInUserEntity)

    fun getOperationState(): LiveData<OperationState>
}
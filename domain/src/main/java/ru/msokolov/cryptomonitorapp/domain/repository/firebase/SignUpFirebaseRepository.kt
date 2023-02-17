package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity

interface SignUpFirebaseRepository {

    fun signUp(userEntity: SignUpUserEntity)

    fun getOperationState(): LiveData<OperationState>
}
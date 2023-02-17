package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.*

interface FirebaseRepository {

    fun getAuthenticationStatus(): LiveData<StatusEntity>

    fun getUserNameOfCurrentUserFromFirebase(): LiveData<UserNameEntity>

    fun logoutFromAccount(): SignInState

    fun signIn(userEntity: SignInUserEntity): LiveData<SignInState>

    fun signUp(userEntity: SignUpUserEntity)

    fun returnOperationState(): LiveData<OperationState>
}
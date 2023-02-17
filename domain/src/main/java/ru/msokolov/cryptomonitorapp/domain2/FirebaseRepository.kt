package ru.msokolov.cryptomonitorapp.domain2

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInState
import ru.msokolov.cryptomonitorapp.domain2.entity.StatusEntity
import ru.msokolov.cryptomonitorapp.domain2.entity.UserNameEntity

interface FirebaseRepository {

    fun getAuthenticationStatus(): LiveData<StatusEntity>

    fun getUserNameOfCurrentUserFromFirebase(): LiveData<UserNameEntity>

    fun logoutFromAccount(): SignInState

    fun signIn(userEntity: SignInUserEntity): LiveData<SignInState>
}
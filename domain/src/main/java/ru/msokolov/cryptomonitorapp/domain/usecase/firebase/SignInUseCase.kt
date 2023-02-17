package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInState
import javax.inject.Inject

class SignInUseCase @Inject constructor(val repository: FirebaseRepository) {

    operator fun invoke(userEntity: SignInUserEntity): LiveData<SignInState>{
        return repository.signIn(userEntity = userEntity)
    }
}
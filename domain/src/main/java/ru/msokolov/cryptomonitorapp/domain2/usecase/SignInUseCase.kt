package ru.msokolov.cryptomonitorapp.domain2.usecase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInState
import javax.inject.Inject

class SignInUseCase @Inject constructor(val repository: FirebaseRepository) {

    operator fun invoke(userEntity: SignInUserEntity): LiveData<SignInState>{
        return repository.signIn(userEntity = userEntity)
    }
}
package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignInFirebaseRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(val repository: SignInFirebaseRepository) {

    operator fun invoke(userEntity: SignInUserEntity){
        repository.signIn(userEntity = userEntity)
    }

    fun getOperationState(): LiveData<OperationState>{
        return repository.getOperationState()
    }
}
package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignUpFirebaseRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(val repository: SignUpFirebaseRepository) {


    operator fun invoke(signUpUserEntity: SignUpUserEntity){
        repository.signUp(signUpUserEntity)
    }

    fun getOperationState(): LiveData<OperationState>{
        return repository.getOperationState()
    }
}
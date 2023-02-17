package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.StatusEntity
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.AuthorizationFirebaseRepository
import javax.inject.Inject

class GetAuthStatusUseCase @Inject constructor(val repository: AuthorizationFirebaseRepository) {

    operator fun invoke(){
        repository.authorization()
    }

    fun getOperationState(): LiveData<OperationState>{
        return repository.getOperationState()
    }
}
package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.LogoutCallback
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.LogoutFirebaseRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(val repository: LogoutFirebaseRepository) {

    operator fun invoke() {
        repository.logout()
    }

    fun getOperationState(): LiveData<LogoutCallback>{
        return repository.getCallback()
    }
}
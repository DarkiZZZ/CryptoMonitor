package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.StatusEntity
import javax.inject.Inject

class GetAuthStatusUseCase @Inject constructor(val repository: FirebaseRepository) {

    operator fun invoke(): LiveData<StatusEntity> {
        return repository.getAuthenticationStatus()
    }
}
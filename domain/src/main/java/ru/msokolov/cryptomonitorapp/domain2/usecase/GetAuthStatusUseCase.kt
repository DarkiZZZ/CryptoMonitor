package ru.msokolov.cryptomonitorapp.domain2.usecase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain2.entity.StatusEntity
import javax.inject.Inject

class GetAuthStatusUseCase @Inject constructor(val repository: FirebaseRepository) {

    operator fun invoke(): LiveData<StatusEntity> {
        return repository.getAuthenticationStatus()
    }
}
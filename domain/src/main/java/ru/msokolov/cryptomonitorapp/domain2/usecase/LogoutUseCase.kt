package ru.msokolov.cryptomonitorapp.domain2.usecase

import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain2.entity.StateEntity
import javax.inject.Inject

class LogoutUseCase @Inject constructor(val repository: FirebaseRepository) {

    operator fun invoke(): StateEntity{
        return repository.logoutFromAccount()
    }
}
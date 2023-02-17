package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInState
import javax.inject.Inject

class LogoutUseCase @Inject constructor(val repository: FirebaseRepository) {

    operator fun invoke(): SignInState {
        return repository.logoutFromAccount()
    }
}
package ru.msokolov.cryptomonitorapp.domain2.usecase

import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository

class GetAuthStatusUseCase(val repository: FirebaseRepository) {

    operator fun invoke(){
        repository.getAuthenticationStatus()
    }
}
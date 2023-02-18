package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import ru.msokolov.cryptomonitorapp.domain.repository.firebase.ChangeProfileFirebaseRepository
import javax.inject.Inject

class ChangeProfileUseCase @Inject constructor(
    private val repository: ChangeProfileFirebaseRepository
) {

    operator fun invoke(){
        repository
    }
}
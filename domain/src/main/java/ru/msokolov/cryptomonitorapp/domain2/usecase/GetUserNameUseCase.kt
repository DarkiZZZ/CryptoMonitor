package ru.msokolov.cryptomonitorapp.domain2.usecase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain2.entity.UserNameEntity
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(val repository: FirebaseRepository){

    operator fun invoke(): LiveData<UserNameEntity>{
        return repository.getUserNameOfCurrentUserFromFirebase()
    }
}
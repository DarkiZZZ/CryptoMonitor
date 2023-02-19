package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState

interface FirebaseRepository {

    fun getOperationState(): LiveData<OperationState>
}
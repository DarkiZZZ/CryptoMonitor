package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState

interface AuthorizationFirebaseRepository {

    fun getOperationState():LiveData<OperationState>

    fun authorization()
}
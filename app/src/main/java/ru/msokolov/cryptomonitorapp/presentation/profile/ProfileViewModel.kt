package ru.msokolov.cryptomonitorapp.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.usecase.firebase.LogoutUseCase
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
): ViewModel() {

    fun logout(){
        logoutUseCase()
    }

    fun getOperationState(): LiveData<OperationState>{
        return logoutUseCase.getOperationState()
    }
}
package ru.msokolov.cryptomonitorapp.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.LogoutCallback
import ru.msokolov.cryptomonitorapp.domain.usecase.firebase.LogoutUseCase
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
): ViewModel() {

    fun logout(){
        logoutUseCase()
    }

    fun getCallback(): LiveData<LogoutCallback>{
        return logoutUseCase.getOperationState()
    }
}
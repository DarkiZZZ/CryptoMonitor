package ru.msokolov.cryptomonitorapp.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.usecase.firebase.GetAuthStatusUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(val getAuthStatusUseCase: GetAuthStatusUseCase) :
    ViewModel() {

    init {
        authorization()
    }

    private fun authorization(){
        getAuthStatusUseCase()
    }

    fun getOperationState(): LiveData<OperationState>{
        return getAuthStatusUseCase.getOperationState()
    }
}
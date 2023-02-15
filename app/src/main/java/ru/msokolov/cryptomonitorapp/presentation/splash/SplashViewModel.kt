package ru.msokolov.cryptomonitorapp.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain2.entity.StatusEntity
import ru.msokolov.cryptomonitorapp.domain2.usecase.GetAuthStatusUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(val getAuthStatusUseCase: GetAuthStatusUseCase) :
    ViewModel() {

    fun isAuthorized(): LiveData<StatusEntity> {
        return getAuthStatusUseCase()
    }
}
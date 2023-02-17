package ru.msokolov.cryptomonitorapp.data.firebase.mapper

import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInState
import javax.inject.Inject

class StateMapper @Inject constructor() {

    fun mapToSuccessStateEntity(): SignInState {
        return SignInState.Success(SUCCESS_MESSAGE)
    }

    fun mapToErrorStateEntity(): SignInState {
        return SignInState.Error(ERROR_MESSAGE)
    }

    companion object{
        private const val SUCCESS_MESSAGE = "You have been logout successfully."
        private const val ERROR_MESSAGE = "Logout failed"
    }
}
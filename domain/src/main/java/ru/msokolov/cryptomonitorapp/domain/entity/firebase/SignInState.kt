package ru.msokolov.cryptomonitorapp.domain.entity.firebase

sealed class SignInState {

    data class Error(val message: String = ""): SignInState()
    data class Success(val message: String = ""): SignInState()
}
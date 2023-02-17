package ru.msokolov.cryptomonitorapp.domain2.entity

sealed class SignInState {

    data class Error(val message: String = ""): SignInState()
    data class Success(val message: String = ""): SignInState()
}
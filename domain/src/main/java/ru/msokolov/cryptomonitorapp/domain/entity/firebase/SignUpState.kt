package ru.msokolov.cryptomonitorapp.domain.entity.firebase

class SignUpState {
    data class Error(val message: String = ""): SignInState()
    data class Success(val message: String = ""): SignInState()
}
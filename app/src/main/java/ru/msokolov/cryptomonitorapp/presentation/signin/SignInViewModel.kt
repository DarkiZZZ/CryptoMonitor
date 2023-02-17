package ru.msokolov.cryptomonitorapp.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain2.entity.SignInState
import ru.msokolov.cryptomonitorapp.domain2.usecase.SignInUseCase
import javax.inject.Inject

class SignInViewModel @Inject constructor(val signInUseCase: SignInUseCase): ViewModel() {

    fun login(email: String, password: String): LiveData<SignInState>{
        val userEntity = mapToSignInUserEntity(email, password)
        return signInUseCase.invoke(userEntity = userEntity)
    }

    fun isLoginDataCorrect(email: String, password: String): Boolean{
        return isInputEmailAndPasswordError(email, password)
    }

    private fun mapToSignInUserEntity(email: String, password: String): SignInUserEntity{
        val editedEmail = email.trim()
        val editedPassword = password.trim()
        return SignInUserEntity(email = editedEmail, password = editedPassword)
    }

    private fun isInputEmailAndPasswordError(email: String, password: String): Boolean{
        return !(email.isBlank() || password.isBlank())
    }
}
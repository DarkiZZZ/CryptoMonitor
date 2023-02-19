package ru.msokolov.cryptomonitorapp.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain.usecase.firebase.SignInUseCase
import javax.inject.Inject

class SignInViewModel @Inject constructor(private val signInUseCase: SignInUseCase) : ViewModel() {

    private val _emptyFieldsListener: MutableLiveData<Unit> = MutableLiveData()
    val emptyFieldsListener: LiveData<Unit> = _emptyFieldsListener

    fun getOperationState(): LiveData<OperationState> {
        return signInUseCase.getOperationState()
    }

    fun signIn(email: String, password: String) {
        if (areFieldsEmpty(email, password)) {
            _emptyFieldsListener.value = Unit
            return
        }
        val signInUserEntity = mapToSignInUserEntity(email, password)
        signInUseCase(userEntity = signInUserEntity)
    }

    private fun areFieldsEmpty(email: String, password: String): Boolean {
        return (email.isBlank() || password.isBlank())
    }

    private fun mapToSignInUserEntity(email: String, password: String): SignInUserEntity {
        return SignInUserEntity(
            email = email.trim(),
            password = password.trim()
        )
    }
}
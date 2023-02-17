package ru.msokolov.cryptomonitorapp.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity
import ru.msokolov.cryptomonitorapp.domain.usecase.firebase.SignUpUseCase
import javax.inject.Inject

class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase) : ViewModel() {

    private val _emptyFieldsListener: MutableLiveData<Unit> = MutableLiveData()
    val emptyFieldsListener: LiveData<Unit> = _emptyFieldsListener

    fun getOperationState(): LiveData<OperationState> {
        return signUpUseCase.getOperationState()
    }

    fun signUp(email: String, password: String, firstName: String, lastName: String, age: String) {
        if (isFieldsEmpty(email, password, firstName, lastName, age)) {
            _emptyFieldsListener.value = Unit
            return
        }
        val signUpUserEntity = mapToSignUpUserEntity(email, password, firstName, lastName, age)
        signUpUseCase(signUpUserEntity = signUpUserEntity)
    }

    private fun isFieldsEmpty(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        age: String
    ): Boolean{
        return !(email.isBlank()
                || password.isBlank()
                || firstName.isBlank()
                || lastName.isBlank()
                || age.isBlank())
    }

    private fun mapToSignUpUserEntity(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        age: String
    ): SignUpUserEntity {
        return SignUpUserEntity(
            email = email.trim(),
            password = password.trim(),
            firstName = firstName.trim(),
            lastName = lastName.trim(),
            age = age.trim().toInt()
        )
    }
}
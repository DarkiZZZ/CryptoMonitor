package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.data.firebase.mapper.SignInUserMapper
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignInFirebaseRepository
import javax.inject.Inject

class SignInFirebaseRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val mapper: SignInUserMapper
    ) : SignInFirebaseRepository {

    private val state: MutableLiveData<OperationState> = MutableLiveData()

    override fun signIn(userEntity: SignInUserEntity) {
        val user = mapper.signInUserEntityToDto(userEntity)

        auth.signInWithEmailAndPassword(user.email, user.password)
            .addOnSuccessListener { authResult ->
                state.value = OperationState.Success(authResult.user.toString())
            }
            .addOnFailureListener { exception ->
                state.value = OperationState.Error(exception.message.toString())
            }
    }

    override fun getOperationState(): LiveData<OperationState> {
        return state
    }
}
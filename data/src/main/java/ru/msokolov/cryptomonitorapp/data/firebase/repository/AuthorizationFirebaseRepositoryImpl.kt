package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.AuthorizationFirebaseRepository
import javax.inject.Inject

class AuthorizationFirebaseRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
    ) : AuthorizationFirebaseRepository {

    private val state: MutableLiveData<OperationState> = MutableLiveData()

    override fun getOperationState(): LiveData<OperationState> {
        return state
    }

    override fun authorization() {
        auth.addAuthStateListener {
            if (it.currentUser != null){
                state.value = OperationState.Success("")
            }
            else{
                state.value = OperationState.Error("")
            }
        }
    }
}
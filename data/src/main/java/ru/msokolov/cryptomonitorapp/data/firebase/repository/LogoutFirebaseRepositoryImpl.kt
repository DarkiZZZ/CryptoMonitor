package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.LogoutFirebaseRepository
import javax.inject.Inject

class LogoutFirebaseRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
    ) : LogoutFirebaseRepository {

    private val state: MutableLiveData<OperationState> = MutableLiveData()

    override fun logout() {
        auth.signOut()
        if (auth.currentUser != null){
            state.value = OperationState.Error("")
        }
        else{
            state.value = OperationState.Success("")
        }
    }

    override fun getOperationState(): LiveData<OperationState> {
        return state
    }
}
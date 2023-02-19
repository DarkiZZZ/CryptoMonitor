package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.ChangeProfileFirebaseRepository
import javax.inject.Inject

class ChangeProfileFirebaseRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
    ): ChangeProfileFirebaseRepository {

    private val state: MutableLiveData<OperationState> = MutableLiveData()

    override fun changeProfile() {
        TODO("Not yet implemented")
    }

    override fun getOperationState(): LiveData<OperationState> {
        return state
    }
}
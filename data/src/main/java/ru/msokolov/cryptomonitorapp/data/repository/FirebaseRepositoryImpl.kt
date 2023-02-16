package ru.msokolov.cryptomonitorapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain2.entity.StatusEntity
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(): FirebaseRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val isAuthorized: MutableLiveData<StatusEntity> = MutableLiveData()

    override fun getAuthenticationStatus(): LiveData<StatusEntity> {
        return isAuthorized
    }

    init {
        auth.addAuthStateListener { firebaseAuth ->
            isAuthorized.value = StatusEntity(firebaseAuth.currentUser != null)
        }
    }
}
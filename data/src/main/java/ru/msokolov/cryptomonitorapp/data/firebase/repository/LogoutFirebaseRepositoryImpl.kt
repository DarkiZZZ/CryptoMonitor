package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.LogoutCallback
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.LogoutFirebaseRepository
import javax.inject.Inject

class LogoutFirebaseRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
    ) : LogoutFirebaseRepository {

    private val callback: MutableLiveData<LogoutCallback> = MutableLiveData()

    override fun logout() {
        auth.signOut()
        callback.value = LogoutCallback()
    }

    override fun getCallback(): LiveData<LogoutCallback> {
        return callback
    }
}
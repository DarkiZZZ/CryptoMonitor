package ru.msokolov.cryptomonitorapp.domain.repository.firebase

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.LogoutCallback

interface LogoutFirebaseRepository {

    fun logout()

    fun getCallback(): LiveData<LogoutCallback>
}
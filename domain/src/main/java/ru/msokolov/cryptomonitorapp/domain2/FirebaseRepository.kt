package ru.msokolov.cryptomonitorapp.domain2

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain2.entity.StatusEntity

interface FirebaseRepository {

    fun getAuthenticationStatus(): LiveData<StatusEntity>
}
package ru.msokolov.cryptomonitorapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import ru.msokolov.cryptomonitorapp.data.mappers.StateMapper
import ru.msokolov.cryptomonitorapp.data.mappers.UserMapper
import ru.msokolov.cryptomonitorapp.domain2.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain2.entity.StateEntity
import ru.msokolov.cryptomonitorapp.domain2.entity.StatusEntity
import ru.msokolov.cryptomonitorapp.domain2.entity.UserNameEntity
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    val stateMapper: StateMapper,
    val userMapper: UserMapper
) : FirebaseRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val isAuthorized: MutableLiveData<StatusEntity> = MutableLiveData()
    private val firebaseUser: MutableLiveData<UserNameEntity> = MutableLiveData()

    override fun getAuthenticationStatus(): LiveData<StatusEntity> {
        return isAuthorized
    }

    override fun getUserNameOfCurrentUserFromFirebase(): LiveData<UserNameEntity> {
        return firebaseUser
    }

    override fun logoutFromAccount(): StateEntity {
        auth.signOut()
        return if (isAuthorized.value != null) {
            stateMapper.mapToErrorStateEntity()
        } else {
            stateMapper.mapToSuccessStateEntity()
        }

    }

    init {
        auth.addAuthStateListener { firebaseAuth ->
            isAuthorized.value = StatusEntity(firebaseAuth.currentUser != null)
            /*firebaseUser.value = userMapper.mapUserDtoToUserNameEntity(firebaseAuth.currentUser)*/
        }
    }
}
package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import ru.msokolov.cryptomonitorapp.data.firebase.mapper.StateMapper
import ru.msokolov.cryptomonitorapp.data.firebase.mapper.UserMapper
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.FirebaseRepository
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.*
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    val stateMapper: StateMapper,
    val userMapper: UserMapper
) : FirebaseRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val isAuthorized: MutableLiveData<StatusEntity> = MutableLiveData()
    private val firebaseUser: MutableLiveData<UserNameEntity> = MutableLiveData()
    private val signInState: MutableLiveData<SignInState> = MutableLiveData()
    private val database = Firebase.database
    private val usersDBRef = database.getReference("Users")
    private val currentUser: MutableLiveData<FirebaseUser> = MutableLiveData()

    private val operationState: MutableLiveData<OperationState> = MutableLiveData()

    override fun getAuthenticationStatus(): LiveData<StatusEntity> {
        return isAuthorized
    }

    override fun getUserNameOfCurrentUserFromFirebase(): LiveData<UserNameEntity> {
        return firebaseUser
    }

    override fun logoutFromAccount(): SignInState {
        auth.signOut()
        return if (isAuthorized.value != null) {
            stateMapper.mapToErrorStateEntity()
        } else {
            stateMapper.mapToSuccessStateEntity()
        }

    }

    override fun signIn(userEntity: SignInUserEntity): LiveData<SignInState> {
        auth.signInWithEmailAndPassword(userEntity.email, userEntity.password)
            .addOnSuccessListener { authResult ->
                 signInState.value = SignInState.Success(authResult.user.toString())
            }
            .addOnFailureListener { exception ->
                signInState.value = SignInState.Error(exception.message.toString())

            }
        return signInState
    }

    override fun signUp(userEntity: SignUpUserEntity) {
        auth.createUserWithEmailAndPassword(userEntity.email,userEntity.password)
            .addOnSuccessListener { authResult ->
                val firebaseUser = authResult.user ?: return@addOnSuccessListener
                val id = firebaseUser.uid
                val userDto = userMapper.mapSignUpUserEntityToUserDto(userEntity, id)
                usersDBRef.child(id).setValue(userDto)
                currentUser.value = authResult.user
            }
    }

    override fun returnOperationState(): LiveData<OperationState> {
        return operationState
    }

    init {
        auth.addAuthStateListener { firebaseAuth ->
            isAuthorized.value = StatusEntity(firebaseAuth.currentUser != null)
            /*firebaseUser.value = userMapper.mapUserDtoToUserNameEntity(firebaseAuth.currentUser)*/

        }
    }
}
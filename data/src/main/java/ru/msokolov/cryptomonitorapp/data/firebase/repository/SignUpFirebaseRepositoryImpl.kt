package ru.msokolov.cryptomonitorapp.data.firebase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import ru.msokolov.cryptomonitorapp.data.firebase.mapper.SignUpUserMapper
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.OperationState
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity
import ru.msokolov.cryptomonitorapp.domain.repository.firebase.SignUpFirebaseRepository
import javax.inject.Inject

class SignUpFirebaseRepositoryImpl @Inject constructor(
    private val userDbRef: DatabaseReference,
    private val auth: FirebaseAuth,
    private val mapper: SignUpUserMapper
) :
    SignUpFirebaseRepository {

    private val state: MutableLiveData<OperationState> = MutableLiveData()

    override fun signUp(userEntity: SignUpUserEntity) {
        auth.createUserWithEmailAndPassword(userEntity.email, userEntity.password)
            .addOnSuccessListener {
                val firebaseUser = it.user ?: return@addOnSuccessListener
                val id = firebaseUser.uid
                val userDto = mapper.mapSignUpUserEntityToUserDto(userEntity, id)
                userDbRef.child(id).setValue(userDto)
                state.value = OperationState.Success("")
            }
            .addOnFailureListener {
                state.value = OperationState.Error(it.message.toString())
            }
    }

    override fun getOperationState(): LiveData<OperationState> {
        return state
    }


}
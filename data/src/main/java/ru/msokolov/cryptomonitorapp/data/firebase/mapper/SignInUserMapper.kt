package ru.msokolov.cryptomonitorapp.data.firebase.mapper

import ru.msokolov.cryptomonitorapp.data.firebase.models.SignInUserDto
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignInUserEntity
import javax.inject.Inject

class SignInUserMapper @Inject constructor() {

    fun signInUserEntityToDto(signInUserEntity: SignInUserEntity): SignInUserDto{
        return SignInUserDto(
            email = signInUserEntity.email,
            password = signInUserEntity.password
        )
    }
}
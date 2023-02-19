package ru.msokolov.cryptomonitorapp.data.firebase.mapper

import ru.msokolov.cryptomonitorapp.data.firebase.models.UserDto
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity
import javax.inject.Inject

class SignUpUserMapper @Inject constructor() {

    fun mapSignUpUserEntityToUserDto(signUpUserEntity: SignUpUserEntity, id: String): UserDto {
        return UserDto(
            id = id,
            firstName = signUpUserEntity.firstName,
            lastName = signUpUserEntity.lastName,
            age = signUpUserEntity.age,
            online = true
        )
    }
}
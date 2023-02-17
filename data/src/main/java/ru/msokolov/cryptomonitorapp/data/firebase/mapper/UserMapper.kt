package ru.msokolov.cryptomonitorapp.data.firebase.mapper

import ru.msokolov.cryptomonitorapp.data.firebase.models.UserDto
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.SignUpUserEntity
import ru.msokolov.cryptomonitorapp.domain.entity.firebase.UserNameEntity
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserDtoToUserNameEntity(user: UserDto): UserNameEntity {
        return UserNameEntity(username = mergeFirstAndLastName(user))
    }

    private fun mergeFirstAndLastName(user: UserDto): String{
        return "${user.firstName} ${user.lastName}"
    }
}
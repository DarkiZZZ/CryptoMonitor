package ru.msokolov.cryptomonitorapp.data.mappers

import ru.msokolov.cryptomonitorapp.data.repository.models.UserDto
import ru.msokolov.cryptomonitorapp.domain2.entity.UserNameEntity
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserDtoToUserNameEntity(user: UserDto): UserNameEntity{
        return UserNameEntity(username = mergeFirstAndLastName(user))
    }

    private fun mergeFirstAndLastName(user: UserDto): String{
        return "${user.firstName} ${user.lastName}"
    }
}
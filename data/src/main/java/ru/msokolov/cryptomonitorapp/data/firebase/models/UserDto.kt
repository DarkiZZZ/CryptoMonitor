package ru.msokolov.cryptomonitorapp.data.firebase.models

import java.io.Serializable

data class UserDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val online: Boolean
): Serializable {
    public constructor() : this(
        "",
        "",
        "",
        -1,
        false
    )
}

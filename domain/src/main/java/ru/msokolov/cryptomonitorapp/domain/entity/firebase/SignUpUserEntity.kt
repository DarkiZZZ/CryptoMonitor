package ru.msokolov.cryptomonitorapp.domain.entity.firebase

data class SignUpUserEntity(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val age: Int
)

package ru.msokolov.cryptomonitorapp.data.exceptions

open class AppException : RuntimeException()

class LogoutFailedException(
    val field: Field
)
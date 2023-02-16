package ru.msokolov.cryptomonitorapp.domain2.entity

sealed class StateEntity {

    class Error(val message: String): StateEntity()
    class Success(val message: String): StateEntity()
}
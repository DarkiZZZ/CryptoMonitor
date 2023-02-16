package ru.msokolov.cryptomonitorapp.domain2.entity

sealed class State {

    class Error(val message: String): State()
    class Result(val result: Any): State()
    class Success(val message: String): State()
}
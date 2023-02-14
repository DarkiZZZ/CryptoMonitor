package ru.msokolov.cryptomonitorapp.presentation

sealed class State {

    class Error(val message: String): State()
    class Result(val result: Any): State()
    class Success(val message: String): State()
}
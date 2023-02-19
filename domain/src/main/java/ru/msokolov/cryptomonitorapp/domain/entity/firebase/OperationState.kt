package ru.msokolov.cryptomonitorapp.domain.entity.firebase

sealed class OperationState{

    data class Error(val message: String = ""): OperationState()
    data class Success(val message: String = ""): OperationState()
}

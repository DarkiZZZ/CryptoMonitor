package ru.msokolov.cryptomonitorapp.data.mappers

import ru.msokolov.cryptomonitorapp.domain2.entity.StateEntity
import javax.inject.Inject

class StateMapper @Inject constructor() {

    fun mapToSuccessStateEntity(): StateEntity {
        return StateEntity.Success(SUCCESS_MESSAGE)
    }

    fun mapToErrorStateEntity(): StateEntity{
        return StateEntity.Error(ERROR_MESSAGE)
    }

    companion object{
        private const val SUCCESS_MESSAGE = "You have been logout successfully."
        private const val ERROR_MESSAGE = "Logout failed"
    }
}
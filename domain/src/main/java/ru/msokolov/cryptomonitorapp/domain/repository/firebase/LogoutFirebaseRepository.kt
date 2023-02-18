package ru.msokolov.cryptomonitorapp.domain.repository.firebase

interface LogoutFirebaseRepository: FirebaseRepository {

    fun logout()
}
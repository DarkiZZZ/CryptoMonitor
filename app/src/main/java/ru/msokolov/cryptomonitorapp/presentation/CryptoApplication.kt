package ru.msokolov.cryptomonitorapp.presentation

import android.app.Application
import ru.msokolov.cryptomonitorapp.di.DaggerApplicationComponent

class CryptoApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}
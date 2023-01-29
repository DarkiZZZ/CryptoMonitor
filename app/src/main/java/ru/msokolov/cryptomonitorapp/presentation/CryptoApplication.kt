package ru.msokolov.cryptomonitorapp.presentation

import android.app.Application
import androidx.work.Configuration
import ru.msokolov.cryptomonitorapp.data.workers.RefreshWorkerFactory
import ru.msokolov.cryptomonitorapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CryptoApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var refreshWorkerFactory: RefreshWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(refreshWorkerFactory)
            .build()
    }
}
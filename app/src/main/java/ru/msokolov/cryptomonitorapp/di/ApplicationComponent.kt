package ru.msokolov.cryptomonitorapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.msokolov.cryptomonitorapp.presentation.CryptoApplication
import ru.msokolov.cryptomonitorapp.presentation.detail.CoinDetailFragment
import ru.msokolov.cryptomonitorapp.presentation.list.CoinPriceListFragment

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class, WorkerModule::class])
interface ApplicationComponent {


    fun inject(fragment: CoinPriceListFragment)
    fun inject(fragment: CoinDetailFragment)
    fun inject(application: CryptoApplication)

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
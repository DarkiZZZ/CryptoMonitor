package ru.msokolov.cryptomonitorapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.msokolov.cryptomonitorapp.presentation.CryptoApplication
import ru.msokolov.cryptomonitorapp.presentation.MainActivity
import ru.msokolov.cryptomonitorapp.presentation.detail.CoinDetailFragment
import ru.msokolov.cryptomonitorapp.presentation.favourite.FavouriteFragment
import ru.msokolov.cryptomonitorapp.presentation.list.CoinPriceListFragment
import ru.msokolov.cryptomonitorapp.presentation.profile.ProfileFragment
import ru.msokolov.cryptomonitorapp.presentation.signin.SignInFragment
import ru.msokolov.cryptomonitorapp.presentation.signup.SignUpFragment
import ru.msokolov.cryptomonitorapp.presentation.splash.SplashFragment

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class, WorkerModule::class])
interface ApplicationComponent {


    fun inject(fragment: CoinPriceListFragment)
    fun inject(fragment: CoinDetailFragment)
    fun inject(application: CryptoApplication)
    fun inject(fragment: FavouriteFragment)
    fun inject(fragment: SplashFragment)
    fun inject(activity: MainActivity)
    fun inject(fragment: SignInFragment)
    fun inject(fragment: SignUpFragment)
    fun inject(fragment: ProfileFragment)

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
package ru.msokolov.cryptomonitorapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.msokolov.cryptomonitorapp.presentation.MainActivityViewModel
import ru.msokolov.cryptomonitorapp.presentation.favourite.FavouriteViewModel
import ru.msokolov.cryptomonitorapp.presentation.list.CoinListViewModel
import ru.msokolov.cryptomonitorapp.presentation.profile.ProfileViewModel
import ru.msokolov.cryptomonitorapp.presentation.signin.SignInViewModel
import ru.msokolov.cryptomonitorapp.presentation.signup.SignUpViewModel
import ru.msokolov.cryptomonitorapp.presentation.splash.SplashViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinListViewModel::class)
    fun bindCoinViewModel(viewModel: CoinListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouriteViewModel::class)
    fun bindFavouriteViewModel(viewModel: FavouriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun bindSignUpViewModel(viewModel: SignUpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}
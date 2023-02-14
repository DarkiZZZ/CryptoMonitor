package ru.msokolov.cryptomonitorapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.msokolov.cryptomonitorapp.presentation.list.CoinListViewModel
import ru.msokolov.cryptomonitorapp.presentation.favourite.FavouriteViewModel

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
}
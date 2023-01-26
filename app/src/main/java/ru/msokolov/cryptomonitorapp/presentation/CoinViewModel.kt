package ru.msokolov.cryptomonitorapp.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.msokolov.cryptomonitorapp.data.repository.CoinRepositoryImpl
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.domain.GetCoinInfoListUseCase
import ru.msokolov.cryptomonitorapp.domain.GetCoinInfoUseCase
import ru.msokolov.cryptomonitorapp.domain.LoadDataUseCase

class CoinViewModel(application: Application) : ViewModel() {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fromSymbol: String): LiveData<CoinInfoEntity> {
        return getCoinInfoUseCase(fromSymbol = fromSymbol)
    }

    init {
        viewModelScope.launch{
            loadDataUseCase()
        }
    }

}
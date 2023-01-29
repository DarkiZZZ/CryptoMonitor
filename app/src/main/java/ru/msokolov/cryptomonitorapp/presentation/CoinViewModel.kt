package ru.msokolov.cryptomonitorapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.domain.GetCoinInfoListUseCase
import ru.msokolov.cryptomonitorapp.domain.GetCoinInfoUseCase
import ru.msokolov.cryptomonitorapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {
    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fromSymbol: String): LiveData<CoinInfoEntity> {
        return getCoinInfoUseCase(fromSymbol = fromSymbol)
    }

    init {
        loadDataUseCase()
    }

}
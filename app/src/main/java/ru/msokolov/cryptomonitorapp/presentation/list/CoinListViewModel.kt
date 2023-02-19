package ru.msokolov.cryptomonitorapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.msokolov.cryptomonitorapp.domain.entity.database.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.domain.usecase.database.GetCoinInfoListUseCase
import ru.msokolov.cryptomonitorapp.domain.usecase.database.GetCoinInfoUseCase
import ru.msokolov.cryptomonitorapp.domain.usecase.firebase.LoadDataUseCase
import javax.inject.Inject

class CoinListViewModel @Inject constructor(
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
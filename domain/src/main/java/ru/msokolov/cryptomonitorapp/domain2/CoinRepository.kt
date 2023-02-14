package ru.msokolov.cryptomonitorapp.domain2

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain2.entity.CoinInfoEntity

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfoEntity>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfoEntity>

    fun loadData()
}
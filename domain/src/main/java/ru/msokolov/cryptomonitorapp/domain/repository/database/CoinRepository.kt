package ru.msokolov.cryptomonitorapp.domain.repository.database

import androidx.lifecycle.LiveData
import ru.msokolov.cryptomonitorapp.domain.entity.database.CoinInfoEntity

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfoEntity>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfoEntity>

    fun loadData()
}
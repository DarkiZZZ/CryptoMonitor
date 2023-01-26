package ru.msokolov.cryptomonitorapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.delay
import ru.msokolov.cryptomonitorapp.data.database.AppDatabase
import ru.msokolov.cryptomonitorapp.data.mappers.CoinMapper
import ru.msokolov.cryptomonitorapp.data.network.ApiFactory
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity
import ru.msokolov.cryptomonitorapp.domain.CoinRepository

class CoinRepositoryImpl(
    private val application: Application
): CoinRepository {

    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CoinMapper()


    override fun getCoinInfoList(): LiveData<List<CoinInfoEntity>> {
        return Transformations.map(coinInfoDao.getPriceList()){
            it.map { coinInfoDbModel ->
                mapper.mapDbModelToEntity(coinInfoDbModel) }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfoEntity> {
        return Transformations.map(coinInfoDao.getPriceInfoAboutCoin(fromSymbol)){
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fromSymbols = mapper.mapNamesListToString(namesList = topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fromSymbols)
                val coinInfoDtoList =
                    mapper.mapJsonContainerToCoinInfoList(jsonContainer = jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDBModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            }
            catch (e: Exception){
                TODO("Transfer data to presentation and toast it")
            }
            delay(10000)
        }
    }
}
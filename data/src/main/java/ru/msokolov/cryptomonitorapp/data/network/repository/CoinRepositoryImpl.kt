package ru.msokolov.cryptomonitorapp.data.network.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import ru.msokolov.cryptomonitorapp.data.database.dao.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.network.mapper.CoinMapper
import ru.msokolov.cryptomonitorapp.data.workers.refreshdata.RefreshDataWorker
import ru.msokolov.cryptomonitorapp.domain.repository.database.CoinRepository
import ru.msokolov.cryptomonitorapp.domain.entity.database.CoinInfoEntity
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val application: Application,
    private val mapper: CoinMapper,
    private val coinInfoDao: CoinInfoDao
): CoinRepository {


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

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }


}
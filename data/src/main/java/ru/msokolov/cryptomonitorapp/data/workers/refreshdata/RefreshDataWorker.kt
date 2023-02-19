package ru.msokolov.cryptomonitorapp.data.workers.refreshdata

import android.content.Context
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.delay
import ru.msokolov.cryptomonitorapp.data.database.dao.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.network.mapper.CoinMapper
import ru.msokolov.cryptomonitorapp.data.network.crypto.CryptoApiService
import javax.inject.Inject

class RefreshDataWorker (
    context: Context,
    workerParameters: WorkerParameters,
    private val coinInfoDao: CoinInfoDao,
    private val cryptoApiService: CryptoApiService,
    private val mapper: CoinMapper
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        while (true) {
            try {

                val topCoins = cryptoApiService.getTopCoinsInfo(limit = 50)
                val fromSymbols = mapper.mapNamesListToString(namesList = topCoins)
                val jsonContainer = cryptoApiService.getFullPriceList(fSyms = fromSymbols)
                val coinInfoDtoList =
                    mapper.mapJsonContainerToCoinInfoList(jsonContainer = jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDBModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
            delay(10000)
        }
    }

    companion object {
        private const val TAG = "CoroutineWorkerTAG"
        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>()
                .build()
        }
    }


    class FactoryRefreshData @Inject constructor(
        private val coinInfoDao: CoinInfoDao,
        private val cryptoApiService: CryptoApiService,
        private val mapper: CoinMapper
    ) : ChildRefreshDataWorkerFactory {

        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(
                context, workerParameters, coinInfoDao, cryptoApiService, mapper
            )
        }
    }
}
package ru.msokolov.cryptomonitorapp.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import ru.msokolov.cryptomonitorapp.data.database.AppDatabase
import ru.msokolov.cryptomonitorapp.data.mappers.CoinMapper
import ru.msokolov.cryptomonitorapp.data.network.ApiFactory

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    private val coinInfoDao = AppDatabase.getInstance(context).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CoinMapper()

    override suspend fun doWork(): Result {
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
                Log.d(TAG, e.message.toString())
            }
            delay(10000)
        }
    }

    companion object{
        private const val TAG = "CoroutineWorkerTAG"
        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest{
            return OneTimeWorkRequestBuilder<RefreshDataWorker>()
                .build()
        }
    }
}
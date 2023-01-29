package ru.msokolov.cryptomonitorapp.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import ru.msokolov.cryptomonitorapp.data.database.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.mappers.CoinMapper
import ru.msokolov.cryptomonitorapp.data.network.ApiService

class RefreshWorkerFactory(
    private val coinInfoDao: CoinInfoDao,
    private val apiService: ApiService,
    private val mapper: CoinMapper
): WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        return RefreshDataWorker(
            appContext,
            workerParameters,
            coinInfoDao,
            apiService,
            mapper
        )
    }
}
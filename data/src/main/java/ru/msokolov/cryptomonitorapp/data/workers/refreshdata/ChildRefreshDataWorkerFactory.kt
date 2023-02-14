package ru.msokolov.cryptomonitorapp.data.workers.refreshdata

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface ChildRefreshDataWorkerFactory {

    fun create(
        context: Context,
        workerParameters: WorkerParameters
    ): ListenableWorker
}
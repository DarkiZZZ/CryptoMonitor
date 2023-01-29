package ru.msokolov.cryptomonitorapp.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import ru.msokolov.cryptomonitorapp.data.workers.refreshdata.ChildRefreshDataWorkerFactory
import ru.msokolov.cryptomonitorapp.data.workers.refreshdata.RefreshDataWorker
import javax.inject.Inject
import javax.inject.Provider

class MainWorkerFactory @Inject constructor(
    private val workerProviders: @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildRefreshDataWorkerFactory>>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when(workerClassName){
            RefreshDataWorker::class.qualifiedName -> {
                val childWorkerFactory = workerProviders[RefreshDataWorker::class.java]?.get()
                childWorkerFactory?.create(appContext, workerParameters) // return value
            }
            else -> null
        }
    }
}
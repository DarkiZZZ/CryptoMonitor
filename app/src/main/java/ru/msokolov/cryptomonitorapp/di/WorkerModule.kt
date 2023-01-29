package ru.msokolov.cryptomonitorapp.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.msokolov.cryptomonitorapp.data.workers.ChildWorkerFactory
import ru.msokolov.cryptomonitorapp.data.workers.RefreshDataWorker

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(refreshDataWorker: RefreshDataWorker.Factory): ChildWorkerFactory
}
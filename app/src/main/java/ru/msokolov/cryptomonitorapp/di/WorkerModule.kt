package ru.msokolov.cryptomonitorapp.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.msokolov.cryptomonitorapp.data.workers.refreshdata.ChildRefreshDataWorkerFactory
import ru.msokolov.cryptomonitorapp.data.workers.refreshdata.RefreshDataWorker

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(refreshDataWorker: RefreshDataWorker.FactoryRefreshData): ChildRefreshDataWorkerFactory
}
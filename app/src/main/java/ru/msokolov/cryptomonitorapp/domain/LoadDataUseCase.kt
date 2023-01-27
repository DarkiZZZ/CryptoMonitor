package ru.msokolov.cryptomonitorapp.domain

class LoadDataUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(){
        repository.loadData()
    }
}
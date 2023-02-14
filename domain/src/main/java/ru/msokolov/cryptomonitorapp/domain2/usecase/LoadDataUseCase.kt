package ru.msokolov.cryptomonitorapp.domain2.usecase

import ru.msokolov.cryptomonitorapp.domain2.CoinRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    val repository: CoinRepository
) {
    operator fun invoke(){
        repository.loadData()
    }
}
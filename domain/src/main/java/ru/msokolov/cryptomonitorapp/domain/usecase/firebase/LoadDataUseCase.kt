package ru.msokolov.cryptomonitorapp.domain.usecase.firebase

import ru.msokolov.cryptomonitorapp.domain.repository.database.CoinRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    val repository: CoinRepository
) {
    operator fun invoke(){
        repository.loadData()
    }
}
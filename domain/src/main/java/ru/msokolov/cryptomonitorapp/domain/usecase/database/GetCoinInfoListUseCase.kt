package ru.msokolov.cryptomonitorapp.domain.usecase.database

import ru.msokolov.cryptomonitorapp.domain.repository.database.CoinRepository
import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(
    val repository: CoinRepository
) {
    operator fun invoke() = repository.getCoinInfoList()
}
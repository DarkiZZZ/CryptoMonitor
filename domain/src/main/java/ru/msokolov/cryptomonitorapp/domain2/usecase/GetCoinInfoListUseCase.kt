package ru.msokolov.cryptomonitorapp.domain2.usecase

import ru.msokolov.cryptomonitorapp.domain2.CoinRepository
import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(
    val repository: CoinRepository
) {
    operator fun invoke() = repository.getCoinInfoList()
}
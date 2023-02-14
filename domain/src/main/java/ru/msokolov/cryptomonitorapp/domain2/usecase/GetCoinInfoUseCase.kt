package ru.msokolov.cryptomonitorapp.domain2.usecase

import ru.msokolov.cryptomonitorapp.domain2.CoinRepository
import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(
    val repository: CoinRepository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol = fromSymbol)
}
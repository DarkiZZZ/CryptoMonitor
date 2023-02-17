package ru.msokolov.cryptomonitorapp.domain.usecase.database

import ru.msokolov.cryptomonitorapp.domain.repository.database.CoinRepository
import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(
    val repository: CoinRepository
) {
    operator fun invoke(fromSymbol: String) = repository.getCoinInfo(fromSymbol = fromSymbol)
}
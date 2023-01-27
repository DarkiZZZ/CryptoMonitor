package ru.msokolov.cryptomonitorapp.domain

class GetCoinInfoListUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke() = repository.getCoinInfoList()
}
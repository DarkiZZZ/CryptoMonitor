package ru.msokolov.cryptomonitorapp.data.mappers

import com.google.gson.Gson
import ru.msokolov.cryptomonitorapp.data.database.CoinInfoDbModel
import ru.msokolov.cryptomonitorapp.data.network.models.CoinInfoDto
import ru.msokolov.cryptomonitorapp.data.network.models.CoinInfoJsonContainerDto
import ru.msokolov.cryptomonitorapp.data.network.models.CoinNamesListDto
import ru.msokolov.cryptomonitorapp.domain.CoinInfoEntity

class CoinMapper {

    fun mapDtoToDBModel(dto: CoinInfoDto) = CoinInfoDbModel(
        fromSymbol = dto.fromSymbol,
        toSymbol = dto.toSymbol,
        price = dto.price,
        lastUpdate = dto.lastUpdate,
        highDay = dto.highDay,
        lowDay = dto.lowDay,
        lastMarket = dto.lastMarket,
        imageUrl = dto.imageUrl
    )

    fun mapJsonContainerToCoinInfoList(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesList: CoinNamesListDto): String {
        return namesList.names?.map {
            it.coinNameDto?.name
        }?.joinToString(",") ?: ""
    }

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel) = CoinInfoEntity(
        fromSymbol = dbModel.fromSymbol,
        toSymbol = dbModel.toSymbol,
        price = dbModel.price,
        lastUpdate = dbModel.lastUpdate,
        highDay = dbModel.highDay,
        lowDay = dbModel.lowDay,
        lastMarket = dbModel.lastMarket,
        imageUrl = dbModel.imageUrl
    )
}
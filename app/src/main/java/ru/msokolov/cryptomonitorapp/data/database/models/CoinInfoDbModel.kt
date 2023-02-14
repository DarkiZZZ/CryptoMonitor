package ru.msokolov.cryptomonitorapp.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(
    @PrimaryKey
    @ColumnInfo(name = "from_symbol") val fromSymbol: String,
    @ColumnInfo(name = "to_symbol") val toSymbol: String?,
    @ColumnInfo(name = "price") val price: String?,
    @ColumnInfo(name = "last_update") val lastUpdate: Long?,
    @ColumnInfo(name = "high_day") val highDay: String?,
    @ColumnInfo(name = "low_day") val lowDay: String?,
    @ColumnInfo(name = "last_market") val lastMarket: String?,
    @ColumnInfo(name = "image_url") val imageUrl: String
)
package ru.msokolov.cryptomonitorapp.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_coin_list")
data class FavouriteCoinDbModel(
    @PrimaryKey
    @ColumnInfo(name = "from_symbol") val fromSymbol: String,
    @ColumnInfo(name = "is_favourite") val isFavourite: Boolean = false
)
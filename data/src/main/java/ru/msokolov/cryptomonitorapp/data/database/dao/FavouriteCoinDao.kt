package ru.msokolov.cryptomonitorapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.msokolov.cryptomonitorapp.data.database.models.FavouriteCoinDbModel

@Dao
interface FavouriteCoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceList(favouriteCoin: FavouriteCoinDbModel)

    @Query("SELECT * FROM favourite_coin_list")
    fun getFavouriteCoinsList(): LiveData<List<FavouriteCoinDbModel>>
}
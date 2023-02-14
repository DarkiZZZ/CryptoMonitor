package ru.msokolov.cryptomonitorapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.msokolov.cryptomonitorapp.data.database.models.CoinInfoDbModel

@Dao
interface CoinInfoDao {
    @Query("SELECT * FROM full_price_list ORDER BY last_update DESC")
    fun getPriceList(): LiveData<List<CoinInfoDbModel>>

    @Query("SELECT * FROM full_price_list WHERE from_symbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPriceList(priceList: List<CoinInfoDbModel>)
}

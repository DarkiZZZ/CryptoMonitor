package ru.msokolov.cryptomonitorapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.msokolov.cryptomonitorapp.data.database.dao.CoinInfoDao
import ru.msokolov.cryptomonitorapp.data.database.dao.FavouriteCoinDao
import ru.msokolov.cryptomonitorapp.data.database.models.CoinInfoDbModel
import ru.msokolov.cryptomonitorapp.data.database.models.FavouriteCoinDbModel

@Database(entities = [CoinInfoDbModel::class, FavouriteCoinDbModel::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun coinPriceInfoDao(): CoinInfoDao
    abstract fun favouriteCoinDao(): FavouriteCoinDao
}

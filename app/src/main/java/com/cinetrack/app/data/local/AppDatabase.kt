package com.cinetrack.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cinetrack.app.data.local.dao.FavoriteDao
import com.cinetrack.app.data.local.dao.SearchHistoryDao
import com.cinetrack.app.data.local.dao.WatchlistDao
import com.cinetrack.app.data.local.entity.FavoriteEntity
import com.cinetrack.app.data.local.entity.SearchHistoryEntity
import com.cinetrack.app.data.local.entity.WatchlistEntity

@Database(
    entities = [
        WatchlistEntity::class,
        SearchHistoryEntity::class,
        FavoriteEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun watchlistDao(): WatchlistDao
    abstract fun searchHistoryDao(): SearchHistoryDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cinetrack_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
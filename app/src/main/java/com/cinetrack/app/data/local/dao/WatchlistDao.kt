package com.cinetrack.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cinetrack.app.data.local.entity.WatchlistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchlistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: WatchlistEntity)

    @Delete
    suspend fun delete(entity: WatchlistEntity)

    @Query("SELECT * FROM watchlist ORDER BY addedAt DESC")
    fun getAll(): Flow<List<WatchlistEntity>>

    @Query("SELECT * FROM watchlist WHERE isWatched = 1 ORDER BY addedAt DESC")
    fun getWatched(): Flow<List<WatchlistEntity>>

    @Query("SELECT * FROM watchlist WHERE isWatched = 0 ORDER BY addedAt DESC")
    fun getUnwatched(): Flow<List<WatchlistEntity>>

    @Query("SELECT COUNT(*) > 0 FROM watchlist WHERE movieId = :movieId")
    fun isInWatchlist(movieId: Int): Flow<Boolean>

    @Query("UPDATE watchlist SET isWatched = :isWatched WHERE movieId = :movieId")
    suspend fun toggleWatched(movieId: Int, isWatched: Boolean)

    @Query("DELETE FROM watchlist WHERE movieId = :movieId")
    suspend fun deleteByMovieId(movieId: Int)

    @Query("SELECT COUNT(*) FROM watchlist")
    fun getCount(): Flow<Int>
}

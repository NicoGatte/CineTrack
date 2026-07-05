package com.cinetrack.app.data.repository

import com.cinetrack.app.data.local.dao.WatchlistDao
import com.cinetrack.app.data.local.entity.WatchlistEntity
import kotlinx.coroutines.flow.Flow

class WatchlistRepository(private val dao: WatchlistDao) {
    fun getAllItems(): Flow<List<WatchlistEntity>> = dao.getAll()
    
    fun getWatchedItems(): Flow<List<WatchlistEntity>> = dao.getWatched()
    
    fun getUnwatchedItems(): Flow<List<WatchlistEntity>> = dao.getUnwatched()
    
    suspend fun addToWatchlist(entity: WatchlistEntity) = dao.insert(entity)
    
    suspend fun removeFromWatchlist(movieId: Int) = dao.deleteByMovieId(movieId)
    
    suspend fun toggleWatched(movieId: Int, isWatched: Boolean) = dao.toggleWatched(movieId, isWatched)
    
    fun isInWatchlist(movieId: Int): Flow<Boolean> = dao.isInWatchlist(movieId)
}

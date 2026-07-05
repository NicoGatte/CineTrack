package com.cinetrack.app.data.repository

import com.cinetrack.app.data.local.dao.FavoriteDao
import com.cinetrack.app.data.local.dao.SearchHistoryDao
import com.cinetrack.app.data.local.entity.FavoriteEntity
import com.cinetrack.app.data.local.entity.SearchHistoryEntity
import kotlinx.coroutines.flow.Flow

class SearchHistoryRepository(
    private val searchHistoryDao: SearchHistoryDao,
    private val favoriteDao: FavoriteDao
) {
    fun getRecentSearches(): Flow<List<SearchHistoryEntity>> = searchHistoryDao.getRecent()
    
    suspend fun addSearch(query: String) = searchHistoryDao.insert(SearchHistoryEntity(query = query))
    
    suspend fun clearHistory() = searchHistoryDao.clearAll()
    
    fun getFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAll()
    
    suspend fun addFavorite(entity: FavoriteEntity) = favoriteDao.insert(entity)
    
    suspend fun removeFavorite(movieId: Int) = favoriteDao.deleteByMovieId(movieId)
    
    fun isFavorite(movieId: Int): Flow<Boolean> = favoriteDao.isFavorite(movieId)
}

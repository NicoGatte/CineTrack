package com.cinetrack.app.di

import android.content.Context
import com.cinetrack.app.data.local.AppDatabase
import com.cinetrack.app.data.api.TmdbApiClient
import com.cinetrack.app.data.repository.MovieRepository
import com.cinetrack.app.data.repository.TvShowRepository
import com.cinetrack.app.data.repository.WatchlistRepository
import com.cinetrack.app.data.repository.SearchHistoryRepository

class AppContainer(context: Context) {
    private val database = AppDatabase.getInstance(context)
    private val apiService = TmdbApiClient.apiService

    val movieRepository = MovieRepository(apiService)
    val tvShowRepository = TvShowRepository(apiService)
    val watchlistRepository = WatchlistRepository(database.watchlistDao())
    val searchHistoryRepository = SearchHistoryRepository(
        database.searchHistoryDao(),
        database.favoriteDao()
    )
}
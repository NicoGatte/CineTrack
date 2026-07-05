package com.cinetrack.app.ui.screens.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.WatchlistRepository
import com.cinetrack.app.domain.model.WatchlistItem
import com.cinetrack.app.domain.model.toDomain
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WatchlistViewModel(private val repository: WatchlistRepository) : ViewModel() {

    val allItems: StateFlow<List<WatchlistItem>> = repository.getAllItems()
        .map { list -> list.map { it.toDomain() } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val watchedItems: StateFlow<List<WatchlistItem>> = repository.getWatchedItems()
        .map { list -> list.map { it.toDomain() } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val unwatchedItems: StateFlow<List<WatchlistItem>> = repository.getUnwatchedItems()
        .map { list -> list.map { it.toDomain() } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun toggleWatched(movieId: Int, isWatched: Boolean) {
        viewModelScope.launch {
            repository.toggleWatched(movieId, isWatched)
        }
    }

    fun removeFromWatchlist(movieId: Int) {
        viewModelScope.launch {
            repository.removeFromWatchlist(movieId)
        }
    }
}

package com.cinetrack.app.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.MovieRepository
import com.cinetrack.app.data.repository.SearchHistoryRepository
import com.cinetrack.app.data.repository.WatchlistRepository
import com.cinetrack.app.domain.model.MovieDetail
import com.cinetrack.app.domain.model.toDomain
import com.cinetrack.app.domain.model.toFavoriteEntity
import com.cinetrack.app.domain.model.toWatchlistEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailViewModel(
    private val movieId: Int,
    private val movieRepository: MovieRepository,
    private val watchlistRepository: WatchlistRepository,
    private val searchHistoryRepository: SearchHistoryRepository
) : ViewModel() {

    private val _movieDetail = MutableStateFlow<MovieDetail?>(null)
    val movieDetail = _movieDetail.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val isInWatchlist: StateFlow<Boolean> = watchlistRepository.isInWatchlist(movieId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    @OptIn(ExperimentalCoroutinesApi::class)
    val isFavorite: StateFlow<Boolean> = searchHistoryRepository.isFavorite(movieId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    init {
        loadMovie()
    }

    fun loadMovie() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            movieRepository.getMovieDetail(movieId).onSuccess { dto ->
                _movieDetail.value = dto.toDomain()
            }.onFailure {
                _error.value = it.message
            }
            
            _isLoading.value = false
        }
    }

    fun toggleWatchlist() {
        viewModelScope.launch {
            val movie = _movieDetail.value ?: return@launch
            if (isInWatchlist.value) {
                watchlistRepository.removeFromWatchlist(movieId)
            } else {
                watchlistRepository.addToWatchlist(movie.toWatchlistEntity())
            }
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            val movie = _movieDetail.value ?: return@launch
            if (isFavorite.value) {
                searchHistoryRepository.removeFavorite(movieId)
            } else {
                searchHistoryRepository.addFavorite(movie.toFavoriteEntity())
            }
        }
    }
}

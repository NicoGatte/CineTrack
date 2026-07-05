package com.cinetrack.app.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.MovieRepository
import com.cinetrack.app.domain.model.Movie
import com.cinetrack.app.domain.model.toDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeUiState(
    val trending: List<Movie> = emptyList(),
    val popular: List<Movie> = emptyList(),
    val nowPlaying: List<Movie> = emptyList(),
    val upcoming: List<Movie> = emptyList(),
    val topRated: List<Movie> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null,
    val isRefreshing: Boolean = false
)

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun loadData(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) {
                _uiState.update { it.copy(isRefreshing = true, error = null) }
            } else {
                _uiState.update { it.copy(isLoading = true, error = null) }
            }

            try {
                // Fetch trending and popular concurrently in a real app, but sequentially is fine here for simplicity
                val trendingResult = repository.getTrending()
                val popularResult = repository.getPopular()
                val nowPlayingResult = repository.getNowPlaying()
                val upcomingResult = repository.getUpcoming()
                val topRatedResult = repository.getTopRated()

                _uiState.update { state ->
                    state.copy(
                        trending = trendingResult.getOrNull()?.map { it.toDomain() } ?: emptyList(),
                        popular = popularResult.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        nowPlaying = nowPlayingResult.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        upcoming = upcomingResult.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        topRated = topRatedResult.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        isLoading = false,
                        isRefreshing = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isLoading = false, 
                        isRefreshing = false,
                        error = e.message ?: "Errore di connessione"
                    )
                }
            }
        }
    }
}

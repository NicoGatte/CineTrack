package com.cinetrack.app.ui.screens.reels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.MovieRepository
import com.cinetrack.app.data.repository.TvShowRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ReelItem(
    val id: Int,
    val isTv: Boolean,
    val title: String,
    val backdropUrl: String?,
    val posterUrl: String?,
    val trailerKey: String? = null,
    val isLoadingTrailer: Boolean = false
)

data class ReelsUiState(
    val items: List<ReelItem> = emptyList(),
    val isLoading: Boolean = true
)

class ReelsViewModel(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ReelsUiState())
    val uiState: StateFlow<ReelsUiState> = _uiState.asStateFlow()

    init { loadItems() }

    private fun loadItems() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val movies = movieRepository.getTrending().getOrNull() ?: emptyList()
            val shows = tvShowRepository.getTrendingTv().getOrNull() ?: emptyList()

            val items = mutableListOf<ReelItem>()
            movies.forEach {
                items.add(ReelItem(
                    id = it.id, isTv = false, title = it.title,
                    backdropUrl = it.backdropPath?.let { p -> "https://image.tmdb.org/t/p/w1280$p" },
                    posterUrl = it.posterPath?.let { p -> "https://image.tmdb.org/t/p/w500$p" }
                ))
            }
            shows.forEach {
                items.add(ReelItem(
                    id = it.id, isTv = true, title = it.name,
                    backdropUrl = it.backdropPath?.let { p -> "https://image.tmdb.org/t/p/w1280$p" },
                    posterUrl = it.posterPath?.let { p -> "https://image.tmdb.org/t/p/w500$p" }
                ))
            }

            _uiState.update { it.copy(items = items.shuffled(), isLoading = false) }
        }
    }

    fun loadTrailerFor(index: Int) {
        val item = _uiState.value.items.getOrNull(index) ?: return
        if (item.trailerKey != null || item.isLoadingTrailer) return

        _uiState.update { state ->
            state.copy(items = state.items.mapIndexed { i, it -> if (i == index) it.copy(isLoadingTrailer = true) else it })
        }

        viewModelScope.launch {
            val videosResult = if (item.isTv) tvShowRepository.getTvVideos(item.id) else movieRepository.getMovieVideos(item.id)
            val key = videosResult.getOrNull()?.let { videos ->
                videos.firstOrNull { it.site == "YouTube" && it.type == "Trailer" }?.key
                    ?: videos.firstOrNull { it.site == "YouTube" }?.key
            }

            _uiState.update { state ->
                state.copy(items = state.items.mapIndexed { i, it ->
                    if (i == index) it.copy(trailerKey = key ?: "", isLoadingTrailer = false) else it
                })
            }
        }
    }
}
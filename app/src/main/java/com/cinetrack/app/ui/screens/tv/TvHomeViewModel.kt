package com.cinetrack.app.ui.screens.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.TvShowRepository
import com.cinetrack.app.domain.model.TvShow
import com.cinetrack.app.domain.model.toDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class TvHomeUiState(
    val trending: List<TvShow> = emptyList(),
    val popular: List<TvShow> = emptyList(),
    val onTheAir: List<TvShow> = emptyList(),
    val topRated: List<TvShow> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)

class TvHomeViewModel(private val repository: TvShowRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(TvHomeUiState())
    val uiState: StateFlow<TvHomeUiState> = _uiState.asStateFlow()

    init { loadData() }

    fun loadData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val trending = repository.getTrendingTv()
                val popular = repository.getPopularTv()
                val onAir = repository.getOnTheAirTv()
                val topRated = repository.getTopRatedTv()

                _uiState.update { state ->
                    state.copy(
                        trending = trending.getOrNull()?.map { it.toDomain() } ?: emptyList(),
                        popular = popular.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        onTheAir = onAir.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        topRated = topRated.getOrNull()?.results?.map { it.toDomain() } ?: emptyList(),
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message ?: "Errore di connessione") }
            }
        }
    }
}
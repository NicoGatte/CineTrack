package com.cinetrack.app.ui.screens.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.repository.TvShowRepository
import com.cinetrack.app.domain.model.TvShowDetail
import com.cinetrack.app.domain.model.toDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TvDetailViewModel(
    private val tvId: Int,
    private val repository: TvShowRepository
) : ViewModel() {
    private val _tvDetail = MutableStateFlow<TvShowDetail?>(null)
    val tvDetail: StateFlow<TvShowDetail?> = _tvDetail.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init { loadTvShow() }

    fun loadTvShow() {
        viewModelScope.launch {
            _isLoading.update { true }
            _error.update { null }
            repository.getTvShowDetail(tvId)
                .onSuccess { dto -> _tvDetail.update { dto.toDomain() } }
                .onFailure { e -> _error.update { e.message ?: "Errore di connessione" } }
            _isLoading.update { false }
        }
    }
}
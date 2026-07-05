package com.cinetrack.app.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinetrack.app.data.local.entity.SearchHistoryEntity
import com.cinetrack.app.data.repository.MovieRepository
import com.cinetrack.app.data.repository.SearchHistoryRepository
import com.cinetrack.app.domain.model.FilterOptions
import com.cinetrack.app.domain.model.Genre
import com.cinetrack.app.domain.model.Movie
import com.cinetrack.app.domain.model.toDomain
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchViewModel(
    private val movieRepository: MovieRepository,
    private val historyRepository: SearchHistoryRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Movie>>(emptyList())
    val searchResults = _searchResults.asStateFlow()

    val recentSearches: StateFlow<List<String>> = historyRepository.getRecentSearches()
        .map { list -> list.map { it.query } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _genres = MutableStateFlow<List<Genre>>(emptyList())
    val genres = _genres.asStateFlow()

    private val _filterOptions = MutableStateFlow(FilterOptions())
    val filterOptions = _filterOptions.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private var searchJob: Job? = null

    init {
        loadGenres()
        
        // Setup debounced search
        viewModelScope.launch {
            _searchQuery.debounce(300).collectLatest { query ->
                if (query.isNotEmpty()) {
                    performSearch(query)
                } else if (_filterOptions.value != FilterOptions()) {
                    performDiscover()
                } else {
                    _searchResults.value = emptyList()
                }
            }
        }
    }

    private fun loadGenres() {
        viewModelScope.launch {
            movieRepository.getGenres().onSuccess { dto ->
                _genres.value = dto.map { Genre(it.id, it.name) }
            }
        }
    }

    fun onQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onSearch(query: String) {
        viewModelScope.launch {
            historyRepository.addSearch(query)
        }
        performSearch(query)
    }

    private fun performSearch(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            movieRepository.searchMovies(query).onSuccess { response ->
                _searchResults.value = response.results.map { it.toDomain() }
            }.onFailure {
                _error.value = it.message
            }
            
            _isLoading.value = false
        }
    }

    fun updateFilters(options: FilterOptions) {
        _filterOptions.value = options
        _searchQuery.value = "" // Clear text search when filtering
        performDiscover()
    }

    private fun performDiscover() {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            val options = _filterOptions.value
            movieRepository.discoverMovies(
                sortBy = options.sortBy.apiValue,
                page = 1,
                withGenres = options.genreId?.toString(),
                year = options.year,
                minRating = if (options.minRating > 0f) options.minRating else null,
                maxRuntime = options.maxRuntime
            ).onSuccess { response ->
                _searchResults.value = response.results.map { it.toDomain() }
            }.onFailure {
                _error.value = it.message
            }
            
            _isLoading.value = false
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            historyRepository.clearHistory()
        }
    }
}

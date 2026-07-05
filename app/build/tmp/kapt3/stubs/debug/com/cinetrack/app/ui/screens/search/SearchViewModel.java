package com.cinetrack.app.ui.screens.search;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010%\u001a\u00020&J\b\u0010\'\u001a\u00020&H\u0002J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\tJ\u000e\u0010*\u001a\u00020&2\u0006\u0010)\u001a\u00020\tJ\b\u0010+\u001a\u00020&H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010)\u001a\u00020\tH\u0002J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u000bR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017\u00a8\u0006/"}, d2 = {"Lcom/cinetrack/app/ui/screens/search/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "movieRepository", "Lcom/cinetrack/app/data/repository/MovieRepository;", "historyRepository", "Lcom/cinetrack/app/data/repository/SearchHistoryRepository;", "(Lcom/cinetrack/app/data/repository/MovieRepository;Lcom/cinetrack/app/data/repository/SearchHistoryRepository;)V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_filterOptions", "Lcom/cinetrack/app/domain/model/FilterOptions;", "_genres", "", "Lcom/cinetrack/app/domain/model/Genre;", "_isLoading", "", "_searchQuery", "_searchResults", "Lcom/cinetrack/app/domain/model/Movie;", "error", "Lkotlinx/coroutines/flow/StateFlow;", "getError", "()Lkotlinx/coroutines/flow/StateFlow;", "filterOptions", "getFilterOptions", "genres", "getGenres", "isLoading", "recentSearches", "getRecentSearches", "searchJob", "Lkotlinx/coroutines/Job;", "searchQuery", "getSearchQuery", "searchResults", "getSearchResults", "clearHistory", "", "loadGenres", "onQueryChange", "query", "onSearch", "performDiscover", "performSearch", "updateFilters", "options", "app_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.MovieRepository movieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.SearchHistoryRepository historyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.cinetrack.app.domain.model.Movie>> _searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.Movie>> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> recentSearches = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.cinetrack.app.domain.model.Genre>> _genres = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.Genre>> genres = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cinetrack.app.domain.model.FilterOptions> _filterOptions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.cinetrack.app.domain.model.FilterOptions> filterOptions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job searchJob;
    
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.MovieRepository movieRepository, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.SearchHistoryRepository historyRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.Movie>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getRecentSearches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.Genre>> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.cinetrack.app.domain.model.FilterOptions> getFilterOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    private final void loadGenres() {
    }
    
    public final void onQueryChange(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final void performSearch(java.lang.String query) {
    }
    
    public final void updateFilters(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.domain.model.FilterOptions options) {
    }
    
    private final void performDiscover() {
    }
    
    public final void clearHistory() {
    }
}
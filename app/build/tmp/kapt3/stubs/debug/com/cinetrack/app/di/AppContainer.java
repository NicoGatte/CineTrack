package com.cinetrack.app.di;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/cinetrack/app/di/AppContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiService", "Lcom/cinetrack/app/data/api/TmdbApiService;", "database", "Lcom/cinetrack/app/data/local/AppDatabase;", "movieRepository", "Lcom/cinetrack/app/data/repository/MovieRepository;", "getMovieRepository", "()Lcom/cinetrack/app/data/repository/MovieRepository;", "searchHistoryRepository", "Lcom/cinetrack/app/data/repository/SearchHistoryRepository;", "getSearchHistoryRepository", "()Lcom/cinetrack/app/data/repository/SearchHistoryRepository;", "watchlistRepository", "Lcom/cinetrack/app/data/repository/WatchlistRepository;", "getWatchlistRepository", "()Lcom/cinetrack/app/data/repository/WatchlistRepository;", "app_debug"})
public final class AppContainer {
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.local.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.api.TmdbApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.MovieRepository movieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.WatchlistRepository watchlistRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.SearchHistoryRepository searchHistoryRepository = null;
    
    public AppContainer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.data.repository.MovieRepository getMovieRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.data.repository.WatchlistRepository getWatchlistRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.data.repository.SearchHistoryRepository getSearchHistoryRepository() {
        return null;
    }
}
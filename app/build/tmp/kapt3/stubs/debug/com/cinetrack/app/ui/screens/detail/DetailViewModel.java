package com.cinetrack.app.ui.screens.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/cinetrack/app/ui/screens/detail/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "movieId", "", "movieRepository", "Lcom/cinetrack/app/data/repository/MovieRepository;", "watchlistRepository", "Lcom/cinetrack/app/data/repository/WatchlistRepository;", "searchHistoryRepository", "Lcom/cinetrack/app/data/repository/SearchHistoryRepository;", "(ILcom/cinetrack/app/data/repository/MovieRepository;Lcom/cinetrack/app/data/repository/WatchlistRepository;Lcom/cinetrack/app/data/repository/SearchHistoryRepository;)V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isLoading", "", "_movieDetail", "Lcom/cinetrack/app/domain/model/MovieDetail;", "error", "Lkotlinx/coroutines/flow/StateFlow;", "getError", "()Lkotlinx/coroutines/flow/StateFlow;", "isFavorite", "isFavorite$annotations", "()V", "isInWatchlist", "isInWatchlist$annotations", "isLoading", "movieDetail", "getMovieDetail", "loadMovie", "", "toggleFavorite", "toggleWatchlist", "app_debug"})
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    private final int movieId = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.MovieRepository movieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.WatchlistRepository watchlistRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.SearchHistoryRepository searchHistoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.cinetrack.app.domain.model.MovieDetail> _movieDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.cinetrack.app.domain.model.MovieDetail> movieDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isInWatchlist = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite = null;
    
    public DetailViewModel(int movieId, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.MovieRepository movieRepository, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.WatchlistRepository watchlistRepository, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.SearchHistoryRepository searchHistoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.cinetrack.app.domain.model.MovieDetail> getMovieDetail() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isInWatchlist() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated()
    public static void isInWatchlist$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isFavorite() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated()
    public static void isFavorite$annotations() {
    }
    
    public final void loadMovie() {
    }
    
    public final void toggleWatchlist() {
    }
    
    public final void toggleFavorite() {
    }
}
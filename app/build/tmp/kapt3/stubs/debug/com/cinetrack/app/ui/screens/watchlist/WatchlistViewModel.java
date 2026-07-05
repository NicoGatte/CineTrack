package com.cinetrack.app.ui.screens.watchlist;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/cinetrack/app/ui/screens/watchlist/WatchlistViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/cinetrack/app/data/repository/WatchlistRepository;", "(Lcom/cinetrack/app/data/repository/WatchlistRepository;)V", "allItems", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/cinetrack/app/domain/model/WatchlistItem;", "getAllItems", "()Lkotlinx/coroutines/flow/StateFlow;", "unwatchedItems", "getUnwatchedItems", "watchedItems", "getWatchedItems", "removeFromWatchlist", "", "movieId", "", "toggleWatched", "isWatched", "", "app_debug"})
public final class WatchlistViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.repository.WatchlistRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.WatchlistItem>> allItems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.WatchlistItem>> watchedItems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.WatchlistItem>> unwatchedItems = null;
    
    public WatchlistViewModel(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.repository.WatchlistRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.WatchlistItem>> getAllItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.WatchlistItem>> getWatchedItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.cinetrack.app.domain.model.WatchlistItem>> getUnwatchedItems() {
        return null;
    }
    
    public final void toggleWatched(int movieId, boolean isWatched) {
    }
    
    public final void removeFromWatchlist(int movieId) {
    }
}